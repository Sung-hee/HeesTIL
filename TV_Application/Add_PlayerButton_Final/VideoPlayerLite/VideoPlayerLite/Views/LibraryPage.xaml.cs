using System.Collections.Generic;
using VideoPlayerLite.Models;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace VideoPlayerLite.Views
{
    public partial class LibraryPage : ContentPage
    {
        private bool isLoaded;

        public static readonly BindableProperty VideoListProperty = BindableProperty.Create("VideoList", typeof(IEnumerable<MediaItem>), typeof(LibraryPage), null);

        public IEnumerable<MediaItem> VideoList
        {
            get { return (IEnumerable<MediaItem>)GetValue(VideoListProperty); }
        }

        public static readonly BindableProperty UpdateVideoListCommandProperty = BindableProperty.Create("UpdateVideoListCommand", typeof(Command), typeof(LibraryPage), null);

        public Command UpdateVideoListCommand
        {
            get { return (Command)GetValue(UpdateVideoListCommandProperty); }
        }

        private void OnPropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            if (e.PropertyName == VideoListProperty.PropertyName)
            {
                UpdateGridItems();
            }
        }

        private void UpdateGridItems()
        {
            var index = 0;

            GridView.Children.Clear();

            foreach (var item in VideoList)
            {
                GridView.Children.Add(new ItemView(item), index / 3, index % 3);
                index++;
            }
        }

        protected override void OnAppearing()
        {
            base.OnAppearing();
            if (!isLoaded)
            {
                UpdateVideoListCommand.Execute(null);
                isLoaded = true;
            }
        }

        public LibraryPage()
        {
            InitializeComponent();
            isLoaded = false;
            PropertyChanged += OnPropertyChanged;
        }
    }
}