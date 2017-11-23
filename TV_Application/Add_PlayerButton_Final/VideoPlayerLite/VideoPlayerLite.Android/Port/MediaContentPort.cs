using System;
using System.IO;
using System.Collections.Generic;
using System.Threading.Tasks;

using Android.App;
using Android.Provider;
using Android.Graphics;
using Android.Database;
using Android.Media;
using Android.Util;

using VideoPlayerLite.Models;

namespace VideoPlayerLite.Android.Port
{
    public class MediaContentPort : IMediaContentAPIs
    {
        private string[] videoProjection =
        {
            MediaStore.Video.VideoColumns.Id,
            MediaStore.Video.VideoColumns.Title,
            MediaStore.Video.VideoColumns.Duration
        };

        public async Task<IEnumerable<MediaItem>> GetAllVideoItemListAsync()
        {
            var itemList = new List<MediaItem>();
            string documentId, path, thumbnailPath;

            var videoUri = MediaStore.Video.Media.ExternalContentUri;
            var cursor = Application.Context.ContentResolver.Query(videoUri, videoProjection, null, null, null);

            if (cursor.Count != 0)
            {
                cursor.MoveToFirst();

                do
                {
                    documentId = cursor.GetString(0);
                    path = GetMediaContentPath(videoUri, documentId);
                    thumbnailPath = await SaveThumbnailToFileAsync(path);

                    itemList.Add(new MediaItem
                    {
                        Title = cursor.GetString(1),
                        Duration = cursor.GetInt(2),
                        Path = path,
                        Thumbnail = thumbnailPath,
                    });
                } while (cursor.MoveToNext());

                cursor.Close();
            }

            return itemList;
        }

        private string GetMediaContentPath(global::Android.Net.Uri uri, string documentId)
        {
            var path = String.Empty;
            ICursor cursor;

            cursor = Application.Context.ContentResolver.Query(uri, null,
                MediaStore.Video.Media.InterfaceConsts.Id + " = ? ", new[] { documentId }, null);

            cursor.MoveToFirst();
            path = cursor.GetString(cursor.GetColumnIndex(MediaStore.Video.Media.InterfaceConsts.Data));

            return path;
        }

        private async Task<string> SaveThumbnailToFileAsync(string path)
        {
            return await Task.Run(() =>
            {
                string thumbnailPath;

                var bmThumbnail = ThumbnailUtils.CreateVideoThumbnail(path, ThumbnailKind.MiniKind);
                if (bmThumbnail != null)
                {
                    thumbnailPath = SaveToFile(path, bmThumbnail);
                }
                else
                {
                    // TODO : Default Thumbnail Image
                    thumbnailPath = String.Empty;
                }

                return thumbnailPath;
            });
        }

        private string SaveToFile(string path, Bitmap bitmap)
        {
            var thumbnailPath = System.IO.Path.ChangeExtension(path, ".jpeg");

            try
            {
                using (var os = new FileStream(thumbnailPath, FileMode.OpenOrCreate))
                {
                    bitmap.Compress(Bitmap.CompressFormat.Jpeg, 95, os);
                }
            }
            catch (Exception e)
            {
                // TODO : Application Name
                Log.Error("MediaContentPort", e.Message);
            }

            return thumbnailPath;
        }
    }
}
