using System;
using Xamarin.Forms;

namespace VideoPlayerLite.Views
{
    public partial class PlayerPage : ContentPage
    {
        public static readonly BindableProperty FetchVideoCommandProperty = BindableProperty.Create("FetchVideoCommand", typeof(Command), typeof(PlayerPage), null);
        public Command FetchVideoCommand
        {
            get => (Command)GetValue(FetchVideoCommandProperty);
        }

        public static readonly BindableProperty PlayerStatusProperty = BindableProperty.Create("PlayerStatus", typeof(PlayerStatus), typeof(PlayerPage), PlayerStatus.Stopped, BindingMode.TwoWay);
        public PlayerStatus PlayerStatus
        {
            get => (PlayerStatus)GetValue(PlayerStatusProperty);
            set => SetValue(PlayerStatusProperty, value);
        }

        public PlayerPage()
        {
            InitializeComponent();

            PlayPauseButton.Clicked += PlayPauseButtonClicked;
            PropertyChanged += OnPropertyChanged;
        }

        protected override void OnAppearing()
        {
            base.OnAppearing();
            PlayPauseButton.SetFocus();
            FetchVideoCommand.Execute(null);
        }

        protected override bool OnBackButtonPressed()
        {
            PlayerStatus = PlayerStatus.Paused;

            return base.OnBackButtonPressed();
        }
        private void PlayPauseButtonClicked(object sender, EventArgs e)
        {
            if (PlayerStatus == PlayerStatus.Playing)
            {
                PlayerStatus = PlayerStatus.Paused;
            }
            else if (PlayerStatus == PlayerStatus.Paused || PlayerStatus == PlayerStatus.Stopped)
            {
                PlayerStatus = PlayerStatus.Playing;
            }
            else
            {
                // The property changed event of the PlayingItem is going to change the PlayerStatus, which of the MediaRenderingViewRenderer.cs(aka.CustomRenderer), to the "Playing" state.
            }
        }

        private void OnPropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            if (e.PropertyName == PlayerPage.PlayerStatusProperty.PropertyName)
            {
                if (PlayerStatus == PlayerStatus.Playing)
                {
                    PlayPauseButton.ButtonImage = "btn_viewer_control_pause_normal.png";
                    ControlPad.IsEnabled = true;
                    PlayPauseButton.SetFocus();
                }
                else if (PlayerStatus == PlayerStatus.Paused)
                {
                    PlayPauseButton.ButtonImage = "btn_viewer_control_play_normal.png";
                }
                else if (PlayerStatus == PlayerStatus.Stopped)
                {
                    PlayPauseButton.ButtonImage = "btn_viewer_control_play_normal.png";
                }
                else if (PlayerStatus == PlayerStatus.Preparing)
                {
                    ControlPad.IsEnabled = false;
                }
            }
        }
    }
}