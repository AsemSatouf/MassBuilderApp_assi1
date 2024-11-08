package com.example.ass1;

public class Exercise {
        private String name;
        private int sets;
        private int reps;
        private String description;



        public Exercise(String name, int sets, int reps,String description) {
            this.name = name;
            this.sets = sets;
            this.reps = reps;
            this.description=description;
        }


        public String getName() {
            return name;
        }

        public int getSets() {
            return sets;
        }

        public int getReps() {
            return reps;
        }

      public String getDescription(){
            return description;
      }



}
