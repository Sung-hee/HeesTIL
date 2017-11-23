using System;
using System.ComponentModel;
using System.Threading;
using Tizen.Multimedia;
using VideoPlayerLite.Tizen.Tizen.TV.Renderer;
using VideoPlayerLite.Views;
using Xamarin.Forms;
using Xamarin.Forms.Platform.Tizen;

[assembly: ExportRenderer(typeof(MediaRenderingView), typeof(MediaRenderingViewRenderer))]
namespace VideoPlayerLite.Tizen.Tizen.TV.Renderer
{
    public class MediaRenderingViewRenderer : ViewRenderer<MediaRenderingView, MediaView>
    {
        private Player player;
        private Timer playPositionTimer;

        protected override void OnElementChanged(ElementChangedEventArgs<MediaRenderingView> e)
        {
            base.OnElementChanged(e);

            if (Control == null)
            {
                SetNativeControl(new MediaView(Forms.Context.MainWindow));
            }

            if (e.OldElement != null)
            {
                StopTimer();
                player.PlaybackCompleted -= PlaybackCompleted;
                player.PlaybackInterrupted -= PlaybackInterrupted;
            }

            if (e.NewElement != null)
            {
                player = new Player();

                StopTimer();
                player.PlaybackCompleted += PlaybackCompleted;
                player.PlaybackInterrupted += PlaybackInterrupted;
            }
        }

        private void PlaybackInterrupted(object sender, PlaybackInterruptedEventArgs e)
        {
            ((IElementController)Element).SetValueFromRenderer(MediaRenderingView.CurrentStatusProperty, PlayerStatus.Stopped);
        }

        private void PlaybackCompleted(object sender, EventArgs e)
        {
            ((IElementController)Element).SetValueFromRenderer(MediaRenderingView.CurrentStatusProperty, PlayerStatus.Stopped);
        }

        protected override void OnElementPropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            base.OnElementPropertyChanged(sender, e);

            if (e.PropertyName == MediaRenderingView.CurrentVideoProperty.PropertyName)
            {
                StopTimer();
                PlayVideo();
            }
            else if (e.PropertyName == MediaRenderingView.CurrentStatusProperty.PropertyName)
            {
                switch (Element.CurrentStatus)
                {
                    case PlayerStatus.Playing:
                        if (player.State == PlayerState.Idle)
                        {
                            PlayVideo();
                        }

                        if (player.State == PlayerState.Ready || player.State == PlayerState.Paused)
                        {
                            player.Start();
                            StartTimer();
                        }
                        break;
                    case PlayerStatus.Paused:
                        if (player.State == PlayerState.Playing)
                        {
                            player.Pause();
                        }

                        StopTimer();
                        break;
                    case PlayerStatus.Stopped:
                        if (player.State == PlayerState.Playing || player.State == PlayerState.Paused)
                        {
                            player.Stop();
                        }

                        if (player.State == PlayerState.Ready)
                        {
                            player.Unprepare();
                        }

                        StopTimer();
                        break;
                    default:
                        break;
                }
            }
        }

        private async void PlayVideo()
        {
            if (player.State == PlayerState.Playing || player.State == PlayerState.Paused)
            {
                player.Stop();
            }

            if (player.State == PlayerState.Ready)
            {
                player.Unprepare();
            }

            try
            {
                player.Display = new Display(Control);
                player.SetSource(new MediaUriSource(Element.VideoPath));
            }
            catch (Exception e)
            {
                Console.WriteLine("Player: " + e.Message);
            }

                 ((IElementController)Element).SetValueFromRenderer(MediaRenderingView.CurrentStatusProperty, PlayerStatus.Preparing);

            try
            {
                await player.PrepareAsync();
                ((IElementController)Element).SetValueFromRenderer(MediaRenderingView.CurrentStatusProperty, PlayerStatus.Playing);
            }
            catch (Exception e)
            {
                ((IElementController)Element).SetValueFromRenderer(MediaRenderingView.CurrentStatusProperty, PlayerStatus.Stopped);
            }
        }

        private void StartTimer()
        {
            if (playPositionTimer != null)
            {
                return;
            }

            playPositionTimer = new Timer((x) =>
            {
                Device.BeginInvokeOnMainThread(() =>
                {
                    if (playPositionTimer != null)
                    {
                        int playPosition = 0;

                        if (player != null && (player.State == PlayerState.Ready || player.State == PlayerState.Paused || player.State == PlayerState.Playing))
                        {
                            playPosition = player.GetPlayPosition();
                        }

                        if (Element == null)
                        {
                            StopTimer();
                        }
                        else
                        {
                            ((IElementController)Element).SetValueFromRenderer(MediaRenderingView.CurrentPositionProperty, playPosition);
                        }
                    }
                });
            }, null, 0, 250);
        }

        private void StopTimer()
        {
            playPositionTimer?.Dispose();
            playPositionTimer = null;
        }
    }
}