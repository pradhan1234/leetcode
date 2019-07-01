# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

import youtube_dl
import sys

class YTD2MP3:
    def __init__(self):
        self.ydl = youtube_dl.YoutubeDL(self.getOptions())
    
    def hook(self, d):
        if d['status'] == 'finished':
            print("Downloaded, Converting....")
        
    def getOptions(self):
        return {
            'format': 'bestaudio/best',
            'postprocessors': [{
                'key': 'FFmpegExtractAudio',
                'preferredcodec': 'mp3',
                'preferredquality': '192',
            }],
            'progress_hooks': [self.hook],
        }

    def startDownload(self, url):
        self.ydl.download([url])

if __name__=="__main__":
    downloader = YTD2MP3()
    url = sys.argv[1]
    downloader.startDownload(url)