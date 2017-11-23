using Android.Widget;
using Xamarin.Forms;
using Xamarin.Forms.Platform.Android;
using System.ComponentModel;
using VideoPlayerLite.Views;
using System.Threading;
using VideoPlayerLite.Android;
using Android.Util;

[assembly: ExportRenderer(typeof(MediaRenderingView), typeof(MediaRenderingViewRenderer))]
namespace VideoPlayerLite.Android
{
    public class MediaRenderingViewRenderer : ViewRenderer<MediaRenderingView, VideoView>
    {
        private static readonly string TAG = "VideoViewRenderer";
        private Timer playPositionTimer;

        protected override void OnElementChanged(ElementChangedEventArgs<MediaRenderingView> e)
        {
            base.OnElementChanged(e);

            if (Control == null)
            {
                SetNativeControl(new VideoView(Context));
            }

            if (e.OldElement != null)
            {
                Control.Completion -= VideoViewCompletion;
                StopTimer();
            }

            if (e.NewElement != null)
            {
                Control.Completion += VideoViewCompletion;
                StopTimer();
            }
        }

        protected override void OnElementPropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            base.OnElementPropertyChanged(sender, e);

            if (e.PropertyName == MediaRenderingView.CurrentVideoProperty.PropertyName)
            {
                ((IElementController)Element).SetValueFromRenderer(MediaRenderingView.CurrentStatusProperty, PlayerStatus.Preparing);

                StopTimer();
                if (Control.IsPlaying)
                {
                    Control.StopPlayback();
                }
                Control.SetVideoPath(Element.VideoPath);

                ((IElementController)Element).SetValueFromRenderer(MediaRenderingView.CurrentStatusProperty, PlayerStatus.Playing);
            }
            else if (e.PropertyName == MediaRenderingView.CurrentStatusProperty.PropertyName)
            {
                switch (Element.CurrentStatus)
                {
                    case PlayerStatus.Playing:
                        Control.Start();
                        StartTimer();
                        break;
                    case PlayerStatus.Paused:
                        Control.Pause();
                        StopTimer();
                        break;
                    case PlayerStatus.Stopped:
                        Control.StopPlayback();
                        Control.SetVideoPath(Element.VideoPath);
                        StopTimer();
                        break;
                    default:
                        break;
                }
            }
        }

        private void VideoViewCompletion(object sender, System.EventArgs e)
        {
            ((IElementController)Element).SetValueFromRenderer(MediaRenderingView.CurrentStatusProperty, PlayerStatus.Stopped);
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

                        try
                        {
                            playPosition = (Control != null) ? Control.CurrentPosition : 0;
                        }
                        catch (System.Exception e)
                        {
                            playPosition = 0;
                            Log.Error(TAG, "Failed to get current position. (" + e.Message + ")");
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
