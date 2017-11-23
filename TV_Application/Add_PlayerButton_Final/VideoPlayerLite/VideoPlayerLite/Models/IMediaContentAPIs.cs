using System.Collections.Generic;
using System.Threading.Tasks;

namespace VideoPlayerLite.Models
{
    public interface IMediaContentAPIs
    {
        Task<IEnumerable<MediaItem>> GetAllVideoItemListAsync();
    }
}