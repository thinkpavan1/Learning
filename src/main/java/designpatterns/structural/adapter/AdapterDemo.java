package designpatterns.structural.adapter;

public class AdapterDemo {

    public static void firstImplementation(){
        MediaPlayer mediaPlayer = new AudioMediaPlayer ();
        mediaPlayer.play ( "aud","First Audio file" );
    }

    public static void secondImplementation() {
        AudioMediaPlayer audioPlayer = new AudioMediaPlayer ();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
    public static void main(String[] args) {
        firstImplementation ();
        secondImplementation (  );
    }
}
