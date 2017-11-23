using System.Collections.Generic;
using VideoPlayerLite.Models;
using Xamarin.Forms;

namespace VideoPlayerLite.ViewModels
{
    public class LibraryPageViewModel : ViewModelBase
    {
        private IEnumerable<MediaItem> videoList;

        public IEnumerable<MediaItem> VideoList
        {
            get => videoList;
            private set
            {
                videoList = value;
                InvokePropertyChanged();
            }
        }

        private Command updateVideoListCommand;

        public Command UpdateVideoListCommand
        {
            get => updateVideoListCommand;
            set
            {
                updateVideoListCommand = value;
                InvokePropertyChanged();
            }
        }

        private async void UpdateItemList()
        {
            await MediaItemProvider.Instance.Update();
            VideoList = MediaItemProvider.Instance.ItemList;
        }

        public LibraryPageViewModel()
        {
            UpdateVideoListCommand = new Command(() => UpdateItemList());
        }

    }
}