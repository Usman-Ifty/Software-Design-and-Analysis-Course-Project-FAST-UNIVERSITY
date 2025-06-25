// AdapterPattern.java
public class AdapterPattern {
    public static void main(String[] args) {
        MediaPlayer adapter = new MediaAdapter();
        adapter.play("MP4", "match.mp4");
        adapter.play("MKV", "highlight.mkv");
        adapter.play("AVI", "unsupported.avi");
    }
}

interface MediaPlayer {
    void play(String videoFormat, String videoFile);
}

class VideoPlayer {
    public void playMP4(String file) {
        System.out.println("Playing MP4 file: " + file);
    }

    public void playMKV(String file) {
        System.out.println("Playing MKV file: " + file);
    }
}

class MediaAdapter implements MediaPlayer {
    private VideoPlayer videoPlayer;

    public MediaAdapter() {
        this.videoPlayer = new VideoPlayer();
    }

    @Override
    public void play(String videoFormat, String videoFile) {
        if (videoFormat.equalsIgnoreCase("MP4")) {
            videoPlayer.playMP4(videoFile);
        } else if (videoFormat.equalsIgnoreCase("MKV")) {
            videoPlayer.playMKV(videoFile);
        } else {
            System.out.println("Unsupported format: " + videoFormat);
        }
    }
}
