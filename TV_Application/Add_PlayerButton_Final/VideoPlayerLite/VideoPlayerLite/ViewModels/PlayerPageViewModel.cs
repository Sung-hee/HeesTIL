using VideoPlayerLite.Models;
using VideoPlayerLite.Views;
using Xamarin.Forms;

namespace VideoPlayerLite.ViewModels
{
    public class PlayerPageViewModel : ViewModelBase
    {
        private static readonly string NEXT_BUTTON = "Next";
        private static readonly string PREV_BUTTON = "Previous";

        private MediaItem selectedVideo;

        public MediaItem SelectedVideo
        {
            get { return selectedVideo; }
            set
            {
                selectedVideo = value;
                InvokePropertyChanged();
            }
        }

        private Command fetchSelectedVideoCommand;

        public Command FetchSelectedVideoCommand
        {
            get => fetchSelectedVideoCommand;
            set
            {
                fetchSelectedVideoCommand = value;
                InvokePropertyChanged();
            }
        }

        private Command controlButtonCommand;

        public Command ControlButtonCommand
        {
            get => controlButtonCommand;
            set
            {
                controlButtonCommand = value;
                InvokePropertyChanged();
            }
        }

        private int currentPosition;

        public int CurrentPosition
        {
            get => currentPosition;
            set
            {
                currentPosition = value;
                InvokePropertyChanged();
            }
        }

        private PlayerStatus currentStatus;

        public PlayerStatus CurrentStatus
        {
            get => currentStatus;
            set
            {
                currentStatus = value;
                InvokePropertyChanged();
            }
        }


        public PlayerPageViewModel()
        {
            FetchSelectedVideoCommand = new Command(() => SelectedVideo = MediaItemProvider.Instance.SelectedItem);

            ControlButtonCommand = new Command<string>((buttonName) =>
            {
                if (buttonName == PREV_BUTTON)
                {
                    SelectedVideo = MediaItemProvider.Instance.MoveToPrev();
                }
                else if (buttonName == NEXT_BUTTON)
                {
                    SelectedVideo = MediaItemProvider.Instance.MoveToNext();
                }
            });
        }
    }
}