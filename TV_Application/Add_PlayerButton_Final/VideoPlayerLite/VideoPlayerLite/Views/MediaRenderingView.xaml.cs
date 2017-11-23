using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using VideoPlayerLite.Models;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace VideoPlayerLite.Views
{
    public enum PlayerStatus
    {
        Playing,
        Paused,
        Stopped,
        Preparing
    }
    public partial class MediaRenderingView : View
    {
        public static readonly BindableProperty CurrentVideoProperty = BindableProperty.Create("CurrentVideo", typeof(MediaItem), typeof(MediaRenderingView), null);
        public MediaItem CurrentVideo
        {
            get => (MediaItem)GetValue(CurrentVideoProperty);
        }

        public string VideoPath { get => CurrentVideo?.Path; }

        public static readonly BindableProperty CurrentStatusProperty = BindableProperty.Create("CurrentStatus", typeof(PlayerStatus), typeof(MediaRenderingView), PlayerStatus.Stopped, BindingMode.TwoWay);
        public PlayerStatus CurrentStatus
        {
            get => (PlayerStatus)GetValue(CurrentStatusProperty);
            set => SetValue(CurrentStatusProperty, value);
        }

        public static readonly BindableProperty CurrentPositionProperty = BindableProperty.Create("CurrentPosition", typeof(int), typeof(MediaRenderingView), 0, BindingMode.OneWayToSource);
        public int CurrentPosition
        {
            get => (int)GetValue(CurrentPositionProperty);
        }

        public MediaRenderingView()
        {
            InitializeComponent();
        }
    }
}