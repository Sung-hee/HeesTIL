using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace VideoPlayerLite.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class PlayerButton : RelativeLayout
    {
        public event EventHandler Clicked;

        public string ButtonImage
        {
            get => Icon.Source.ToString();
            set
            {
                Icon.Source = value;
                OnPropertyChanged();
            }
        }

        public string ButtonName
        {
            get => ControlButton.CommandParameter.ToString();
            set => ControlButton.CommandParameter = value;
        }

        public PlayerButton()
        {
            InitializeComponent();

            ControlButton.Clicked += (s, e) => Clicked?.Invoke(this, EventArgs.Empty);
        }
        public void SetFocus()
        {
            ControlButton.Focus();
        }
    }
}