using VideoPlayerLite.Models;
using Xamarin.Forms;

namespace VideoPlayerLite.ViewModels
{
    public class ItemViewModel : ViewModelBase
    {
        private MediaItem videoItem;

        public MediaItem VideoItem
        {
            get => videoItem;
            set
            {
                videoItem = value;
                InvokePropertyChanged();
            }
        }

        private Command setNewVideoCommand;

        public Command SetNewVideoCommand
        {
            get => setNewVideoCommand;
            set
            {
                setNewVideoCommand = value;
                InvokePropertyChanged();
            }
        }

        public ItemViewModel(MediaItem item)
        {
            VideoItem = item;
            SetNewVideoCommand = new Command(() => MediaItemProvider.Instance.SelectedItem = VideoItem);
        }
    }
}
