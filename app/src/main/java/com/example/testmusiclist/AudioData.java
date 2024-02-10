package com.example.testmusiclist;


    public class AudioData {
        private String audioFile;
        private String title;
        private String subTitle;
        String imageFile;

        public AudioData(String audioFile, String title, String subTitle, String image) {
            this.audioFile = audioFile;
            this.title = title;
            this.subTitle = subTitle;
            this.imageFile=image;
        }

        public AudioData() {
        }

        public String getAudioFile() {
            return audioFile;
        }

        public void setAudioFile(String audioFile) {
            this.audioFile = audioFile;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getImage() {
            return imageFile;
        }

        public void setImage(String image) {
            this.imageFile = image;
        }
    }

