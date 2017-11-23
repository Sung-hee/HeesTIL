using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace VideoPlayerLite.Models
{
    public sealed class MediaItemProvider
    {
        private static readonly Lazy<MediaItemProvider> lazy = new Lazy<MediaItemProvider>(() => new MediaItemProvider());
        public static MediaItemProvider Instance { get => lazy.Value; }

        private static IMediaContentAPIs mediaContentAPIs;

        private IEnumerable<MediaItem> itemList;
        public IEnumerable<MediaItem> ItemList { get => itemList; }

        private MediaItem selectedItem;
        private int selectedItemIndex;

        public MediaItem SelectedItem
        {
            get => selectedItem;
            set
            {
                selectedItem = value;
                selectedItemIndex = itemList.ToList().IndexOf(selectedItem);
            }
        }

        public MediaItem MoveToNext()
        {
            selectedItemIndex++;

            if (selectedItemIndex == itemList.Count())
            {
                selectedItemIndex = 0;
            }

            return selectedItem = itemList.ElementAt(selectedItemIndex);
        }

        public MediaItem MoveToPrev()
        {
            selectedItemIndex--;

            if (selectedItemIndex < 0)
            {
                selectedItemIndex = itemList.Count() - 1;
            }

            return selectedItem = itemList.ElementAt(selectedItemIndex);
        }

        private MediaItemProvider()
        {
            if (DependencyService.Get<IMediaContentAPIs>() != null)
            {
                mediaContentAPIs = DependencyService.Get<IMediaContentAPIs>();
            }
        }

        public async Task Update()
        {
            itemList = await mediaContentAPIs.GetAllVideoItemListAsync();
        }
    }
}