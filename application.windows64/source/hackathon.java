import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class hackathon extends PApplet {

Exam[] exams = {
  // Year 1
  new Exam("CH1531", "Monday, October 19, 2020", "0800 - 0915 (P1), 0945 - 1045 (P2)", "Higher Chinese I", "D1-13, D1-14, D2-03, D2-04"), 
  new Exam("CL1531", "Monday, October 19, 2020", "0800 - 0915 (P1), 0945 - 1045 (P2)", "Chinese I", "D1-05"), 
  new Exam("TH1531", "Monday, October 19, 2020", "0800 - 0915 (P1), 0945 - 1045 (P2)", "Higher Tamil I", "E1-13/14"), 
  new Exam("TL1531", "Monday, October 19, 2020", "0800 - 0915 (P1), 0945 - 1045 (P2)", "Tamil I", "D4-16, D4-17"), 
  new Exam("EL1131", "Monday, October 19, 2020", "1430 - 1600", "Language and Literary Studies I", "D1-04, D1-05, D1-13, D1-14, D2-03, D2-04"), 
  new Exam("PC1131", "Wednesday, October 21, 2020", "0800 - 1000", "Foundations in Physics I", "D1-04, D1-05, D1-13, D1-14, D2-03, D2-04"), 
  new Exam("CM1131", "Thursday, October 22, 2020", "0800 - 1000", "Foundations in Chemistry I", "D1-04, D1-05, D1-13, D1-14, D2-03, D2-04"), 
  new Exam("MA1132", "Friday, October 23, 2020", "0800 - 0930", "Foundations in Mathematics IB", "D1-04, D1-05, D1-13, D1-14, D2-03, D2-04"), 
  new Exam("BL1131", "Monday, October 26, 2020", "1400 - 1530", "Foundations in Biology I", "D1-04, D1-05, D1-13, D1-14, D2-03, D2-04"), 
  new Exam("CS1131", "Wednesday, October 28, 2020", "0800 - 0915", "Computational Thinking", "D1-04, D1-05, D1-13, D1-14, D2-03, D2-04"), 
  new Exam("FR1232", "Thursday, October 29, 2020", "0800 - 0930", "French as 3rd Language IB", "D1-04/05"), 
  new Exam("JP1232", "Thursday, October 29, 2020", "0800 - 0930", "Japanese as 3rd Language IB", "D1-13, D1-14"), 
  new Exam("CL1232", "Thursday, October 29, 2020", "0800 - 0900", "Chinese as 3rd Language IB", "D2-04"), 
  new Exam("ML1232", "Thursday, October 29, 2020", "0800 - 0900", "Malay as 3rd Language IB", "D2-04"), 
  // Year 2
  new Exam("CH2531", "Monday, October 19, 2020", "0800 - 0915 (P1), 0945 - 1045 (P2)", "Higher Chinese II", "D4-05, D4-06, D4-07, D4-08"), 
  new Exam("CL2531", "Monday, October 19, 2020", "0800 - 0915 (P1), 0945 - 1045 (P2)", "Chinese II", "D4-16, D4-17"), 
  new Exam("CL2331", "Monday, October 19, 2020", "0800 - 0850 (P1), 0920 - 1020(P2)", "Basic Chinese II", "B4-11"), 
  new Exam("ML2531", "Monday, October 19, 2020", "0800 - 0915 (P1), 0945 - 1045 (P2)", "Malay II", "E1-13/14"), 
  new Exam("TH2531", "Monday, October 19, 2020", "0800 - 0915 (P1), 0945 - 1045 (P2)", "Higher Tamil II", "E1-13/14"), 
  new Exam("TL2531", "Monday, October 19, 2020", "0800 - 0915 (P1), 0945 - 1045 (P2)", "Tamil II", "D4-16, D4-17"), 
  new Exam("EL2131", "Monday, October 19, 2020", "1430 - 1610", "Language and Literary Studies II", "D4-05, D4-06, D4-07, D4-08, D4-16, D4-17, B4-12"), 
  new Exam("EN2131", "Wednesday, October 21, 2020", "0800 - 1000", "Literary Genres I", "D4-05, D4-06, D4-07, D4-08, D4-16, D4-17, B4-12"), 
  new Exam("GE2131", "Wednesday, October 21, 2020", "0800 - 1000", "Geography Studies II", "D4-05, D4-06, D4-07, D4-08, D4-16, D4-17, B4-12"), 
  new Exam("HY2131", "Wednesday, October 21, 2020", "0800 - 1000", "History Genres II", "D4-05, D4-06, D4-07, D4-08, D4-16, D4-17, B4-12"), 
  new Exam("BL2131", "Thursday, October 22, 2020", "0800 - 1000", "Foundations in Biology II", "D4-05, D4-06, D4-07, D4-08, D4-16, D4-17, B4-12"), 
  new Exam("MA2132", "Friday, October 23, 2020", "1430 - 1630", "Foundations in Mathematics IIB", "D4-05, D4-06, D4-07, D4-08, D4-16, D4-17, B4-12"), 
  new Exam("PC2131", "Monday, October 26, 2020", "1400 - 1600", "Foundations in Physics II", "D4-05, D4-06, D4-07, D4-08, D4-16, D4-17, B4-12"), 
  new Exam("CM2131", "Tuesday, October 27, 2020", "0800 - 1000", "Foundations in Chemistry II", "D4-05, D4-06, D4-07, D4-08, D4-16, D4-17, B4-12"), 
  new Exam("FR2232", "Thursday, October 29, 2020", "0800 - 0930", "French as 3rd Language IIB", "D1-04/05"), 
  new Exam("JP2232", "Thursday, October 29, 2020", "0800 - 0930", "Japanese as 3rd Language IIB", "D1-13, D1-14"), 
  new Exam("CL2232", "Thursday, October 29, 2020", "0800 - 0900", "Chinese as 3rd Language IIB", "D2-04"), 
  new Exam("ML2232", "Thursday, October 29, 2020", "0800 - 0900", "Malay as 3rd Language IIB", "D2-04"), 
  // Year 3
  new Exam("CH3531", "Monday, October 19, 2020", "0800 - 1000 (P1), 1030 - 1215 (P2)", "Higher Chinese III", "B4-02, B4-03, B4-04"), 
  new Exam("CL3531", "Monday, October 19, 2020", "0800 - 1000 (P1), 1030 - 1200 (P2)", "Chinese III", "B5-02, B5-03"), 
  new Exam("CL3331", "Monday, October 19, 2020", "0800 - 0850 (P1), 0920 - 1020 (P2)", "Basic Chinese III", "B4-11"), 
  new Exam("TH3531", "Monday, October 19, 2020", "0800 - 1000 (P1), 1030 - 1215 (P2)", "Higher Tamil III", "E2-10/E2-11"), 
  new Exam("EL3131", "Monday, October 19, 2020", "1430 - 1540", "Exposition and Argumentation: Community and Society", "B4-02, B4-03, B4-04, B5-02, B5-03, B5-04, B5-05"), 
  new Exam("EN3131", "Wednesday, October 21, 2020", "0800 - 1000", "Literary Genres II", "B4-02, B4-03, B4-04, B5-02, B5-03, B5-04, B5-05"), 
  new Exam("GE3132", "Wednesday, October 21, 2020", "0800 - 1000", "Geography Studies IV", "B4-02, B4-03, B4-04, B5-02, B5-03, B5-04, B5-05"), 
  new Exam("HY3132", "Wednesday, October 21, 2020", "0800 - 1000", "History Studies IV", "B4-02, B4-03, B4-04, B5-02, B5-03, B5-04, B5-05"), 
  new Exam("MA3132", "Thursday, October 22, 2020", "1400 - 1600", "Foundations in Mathematics IIIB", "B4-02, B4-03, B4-04, B5-02, B5-03, B5-04, B5-05"), 
  new Exam("BL3131", "Thursday, October 22, 2020", "0800 - 1015", "Foundations in Biology III", "B4-02, B4-03, B4-04, B5-02, B5-03, B5-04, B5-05"), 
  new Exam("CM3131", "Monday, October 26, 2020", "1400 - 1600", "Foundations in Chemistry III", "B4-02, B4-03, B4-04, B5-02, B5-03, B5-04, B5-05"), 
  new Exam("PC3131", "Wednesday, October 28, 2020", "0800 - 1015", "Foundations in Physics III", "B4-02, B4-03, B4-04, B5-02, B5-03, B5-04, B5-05"), 
  new Exam("FR3232", "Thursday, October 29, 2020", "0800 - 0930", "French as 3rd Language IIIB", "D1-04/D1-05"), 
  new Exam("JP3232", "Thursday, October 29, 2020", "0800 - 0930", "Japanese as 3rd Language IIIB", "D1-13, D1-14"), 
  new Exam("CL3232", "Thursday, October 29, 2020", "0800 - 0900 (P1), 0915 - 1015 (P2)", "Chinese as 3rd Language IIIB", "D2-04"), 
  new Exam("ML3232", "Thursday, October 29, 2020", "0800 - 0900 (P1), 0915 - 1015 (P2)", "Malay as 3rd Language IIIB", "D2-04"), 
  // Year 4
  new Exam("CH4531", "Monday, October 19, 2020", "0800 - 1000 (P1), 1030 - 1215 (P2)", "Higher Chinese IV", "D5-05, D5-06, D5-07, D5-08"), 
  new Exam("CL4531", "Monday, October 19, 2020", "0800 - 1000 (P1), 1030 - 1200 (P2)", "Chinese IV", "D5-16"), 
  new Exam("CL4331", "Monday, October 19, 2020", "0800 - 0850 (P1), 0920 - 1020 (P2)", "Basic Chinese IV", "B4-11"), 
  new Exam("MH4531", "Monday, October 19, 2020", "0800 - 1000 (P1), 1030 - 1215 (P2)", "Higher Malay IV", "E2-10/11"), 
  new Exam("TH4531", "Monday, October 19, 2020", "0800 - 1000 (P1), 1030 - 1215 (P2)", "Higher Tamil IV", "E2-10/11"), 
  new Exam("EL4131", "Monday, October 19, 2020", "1430 - 1600", "Critical Reading and Writing: Social Institutions and Issues", "D5-05, D5-06, D5-07, D5-08, D5-16, D5-17, B4-11"), 
  new Exam("CM4132", "Wednesday, October 21, 2020", "1430 - 1600", "Chemical Kinetics and Equilibria", "D5-05, D5-06, D5-07, D5-08, D5-16, D5-17, B4-11"), 
  new Exam("MA4132", "Thursday, October 22, 2020", "0800 - 0930", "Advanced Mathematics IB", "D5-05, D5-06, D5-07, D5-08, D5-16, D5-17, B4-11"), 
  new Exam("PC4132", "Friday, October 23, 2020", "1430 - 1700", "Advanced Physics II", "D5-05, D5-06, D5-07, D5-08, D5-16"), 
  new Exam("BL4131", "Tuesday, October 27, 2020", "0800 - 1030", "Advanced Biology I", "D5-05, D5-06, D5-07, D5-08"), 
  new Exam("FR4232", "Thursday, October 29, 2020", "0800 - 0930", "French as 3rd Language IVB", "D1-04/05"), 
  new Exam("JP4232", "Thursday, October 29, 2020", "0800 - 0930", "Japanese as 3rd Language IVB", "D1-13, D1-14"), 
  new Exam("CL4232", "Thursday, October 29, 2020", "0800 - 0945 (P1), 1000 - 1115 (P2)", "Chinese as 3rd Language IVB", "D2-04"), 
  new Exam("ML4232", "Thursday, October 29, 2020", "0800 - 0945 (P1), 1000 - 1115 (P2)", "Malay as 3rd Language IVB", "D2-04"), 
  // Year 5
  new Exam("CL5531", "Monday, October 19, 2020", "0800 - 1110", "Chinese V", "E5-09/10"), 
  new Exam("ML5531", "Monday, October 19, 2020", "0800 - 1110", "Malay V", "E5-09/10"), 
  new Exam("TL5531", "Monday, October 19, 2020", "0800 - 1110", "Tamil V", "E5-09/10"), 
  new Exam("EL5131", "Monday, October 19, 2020", "1430 - 1600", "Critical Reading and Writing 2: The Global Connection", "E1-13, E1-14. E1-15, E1-16, E2-10, E2-11, E2-08"), 
  new Exam("CM5132", "Wednesday, October 21, 2020", "1400 - 1630", "Thermodynamics and Electrochemistry", "E1-13, E1-14, E1-15, E1-16, E2-10, E2-11, E2-08"), 
  new Exam("MA5131", "Thursday, October 22, 2020", "1400 - 1630", "Statistics", "E1-13, E1-14, E1-15, E1-16, E2-10, E2-11, E2-08"), 
  new Exam("PC5432", "Friday, October 23, 2020", "0800 - 0930", "Calculus-based Physics II", "E2-10/11"), 
  new Exam("PC5132", "Tuesday, October 27, 2020", "0800 - 1030", "Advanced Physics IV", "E1-13, E1-14, E1-15, E1-16, E2-10"), 
  new Exam("MA5432", "Tuesday, October 27, 2020", "1400 - 1530", "Polar Coordinates, Parametric Equations & Vector Functions", "E2-10/11"), 
  new Exam("BL5131", "Wednesday, October 28, 2020", "0800 - 1030", "Advanced Biology II", "E2-10/11, E2-08"), 
  new Exam("CM5432", "Wednesday, October 28, 2020", "1400 - 1600", "Structural Elucidation", "E2-10/11"), 
  new Exam("CS5132", "Thursday, October 29, 2020", "0800 - 0930", "Data Structures and Algorithms", "E2-10/11"), 
  // Year 6
  new Exam("MA6105/MA6132", "Monday, October 5, 2020", "0800 - 0930/0800 - 1000", "Advanced Mathematics V/Advanced Mathematics II", "E2-14, E2-15, E5-09, E5-10, E2-07, E5-12, E5-13"), 
  new Exam("CM6403", "Tuesday, October 6, 2020", "0800 - 1030", "Analytical Chemistry", "E5-09/E5-10"), 
  new Exam("CS6102", "Tuesday, October 6, 2020", "1400 - 1530", "Computer Networking", "E5-09/E5-10"), 
  new Exam("MA6403", "Wednesday, October 7, 2020", "0800 - 0930", "Introduction to Operational Research", "E5-09/E5-10"), 
  new Exam("MA6405", "Wednesday, October 7, 2020", "0800 - 0930", "Introduction to Graph Theory", "E5-09/E5-10"), 
  new Exam("BL6404", "Wednesday, October 7, 2020", "1400 - 1600", "Advanced Biochemistry", "E5-09/E5-10"), 
};










Exam[] currentExams = new Exam[80];
float offset = 0;
Dropdown yearSelect;
Button addModule;
Dropdown moduleSelect;
Button confirmModule;
Button saveExams;
boolean popUpOpen = false;
boolean openMenu = false;
int clickIndex = 0;
JSONArray savedExams = new JSONArray();
PImage clock, calender;
float timer = 3;
boolean showing = false;
boolean loadImages = true;

public void setup() {
  
  String[] options = {"Year 1", "Year 2", "Year 3", "Year 4", "Year 5", "Year 6"};
  yearSelect = new Dropdown(width / 4, height / 8 + 75, 150, 50, options, 6, "yearSelect");
  addModule = new Button(width / 4, height / 8 * 7 - 75, 200, 50, "Add Module...", "addModule");
  String[] examStrings = new String[80];
  for (int i = 0; i < exams.length; i++) {
    if (exams[i] != null) {
      examStrings[i] = exams[i].code + ", " + exams[i].title;
    }
  }
  try {
    clock = loadImage("data/clock.jpg");
    calender = loadImage("data/calender.jpg");
  } 
  catch (Exception e) {
    loadImages = false;
  }
  moduleSelect = new Dropdown(width / 2, height / 6, width - 200, 50, examStrings, 8, "moduleSelect");
  confirmModule = new Button(width / 2, height / 6 * 5, 200, 50, "Add", "confirmModule");
  saveExams = new Button(width / 4, height / 16 * 15, 150, 50, "Save Exams", "saveExams");
  int year = yearSelect.state.charAt(5) - 48;
  int i = 0;
  currentExams = new Exam[80];
  try {
    savedExams = loadJSONArray("savedExams.json");
    for (int j = 0; j < savedExams.size(); j++) {
      JSONObject exam = savedExams.getJSONObject(j);
      String code = exam.getString("code");
      String date = exam.getString("date");
      String time = exam.getString("time");
      String title = exam.getString("title");
      String venue = exam.getString("venue");
      currentExams[j] = new Exam(code, date, time, title, venue);
    }
  } 
  catch (Exception e) {
    for (Exam exam : exams) {
      if (exam.code.charAt(2) - 48 == year) {
        currentExams[i] = exam;
        i++;
      }
    }
  }
}

public void mouseWheel(MouseEvent event) {
  float e = event.getCount();
  if (!popUpOpen) {
    offset -= e * 20;
    int len = 0;
    for (Exam exam : currentExams) {
      if (exam != null) len++;
    }
    if (offset < -75 * (len + 1) + height) {
      offset = -75 * (len + 1) + height;
    }
    if (offset > 0) {
      offset = 0;
    }
  }
  if (popUpOpen && moduleSelect.onButton) moduleSelect.ownOffset += PApplet.parseInt(e);
  if (moduleSelect.ownOffset > moduleSelect.options.length - moduleSelect.maxBoxes) {
    moduleSelect.ownOffset = moduleSelect.options.length - moduleSelect.maxBoxes;
  }
  if (moduleSelect.ownOffset < 0) {
    moduleSelect.ownOffset = 0;
  }
}

public void draw() {
  background(255);
  push();
  stroke(0);
  strokeWeight(3);
  noFill();
  line(width / 2, -10, width / 2, height + 10);
  rect(0, 0, width, height);
  if (loadImages) {
    imageMode(CENTER);
    image(clock, width / 4, height / 2, 150, 150);
  }
  fill(0);
  noStroke();
  textSize(32);
  textAlign(CENTER, CENTER);
  text("Select year:", width / 4, height / 8);
  if (showing) {
    textSize(30);
    fill(0, 0, 255, map(timer, 0, 3, 0, 255));
    text("Saved!", width / 4, height / 16 * 15 - 60);
    timer -= 0.05f;
    if (timer <= 0) {
      timer = 0;
      showing = false;
    }
  }
  yearSelect.show();
  addModule.show();
  saveExams.show();
  showExams();
  if (popUpOpen) showPopUp();
  pop();
}

public void keyPressed() {
  if (keyCode == 38) {
    float e = -1;
    if (!popUpOpen) {
      offset -= e * 20;
      int len = 0;
      for (Exam exam : currentExams) {
        if (exam != null) len++;
      }
      if (offset < -75 * (len + 1) + height) {
        offset = -75 * (len + 1) + height;
      }
      if (offset > 0) {
        offset = 0;
      }
    }
    if (popUpOpen && moduleSelect.onButton) moduleSelect.ownOffset += PApplet.parseInt(e);
    if (moduleSelect.ownOffset > moduleSelect.options.length - moduleSelect.maxBoxes) {
      moduleSelect.ownOffset = moduleSelect.options.length - moduleSelect.maxBoxes;
    }
    if (moduleSelect.ownOffset < 0) {
      moduleSelect.ownOffset = 0;
    }
  }
  if (keyCode == 40) {
    float e = 1;
    if (!popUpOpen) {
      offset -= e * 20;
      int len = 0;
      for (Exam exam : currentExams) {
        if (exam != null) len++;
      }
      if (offset < -75 * (len + 1) + height) {
        offset = -75 * (len + 1) + height;
      }
      if (offset > 0) {
        offset = 0;
      }
    }
    if (popUpOpen && moduleSelect.onButton) moduleSelect.ownOffset += PApplet.parseInt(e);
    if (moduleSelect.ownOffset > moduleSelect.options.length - moduleSelect.maxBoxes) {
      moduleSelect.ownOffset = moduleSelect.options.length - moduleSelect.maxBoxes;
    }
    if (moduleSelect.ownOffset < 0) {
      moduleSelect.ownOffset = 0;
    }
  }
}

public void showExams() {
  push();
  for (int i = 0; i < currentExams.length; i++) {
    if (currentExams[i] != null) {
      Exam e = currentExams[i];
      stroke(0);
      strokeWeight(3);
      fill(255);
      rect(width / 2, (i + 1) * 75 + offset, width / 2, 75);
      line(width / 4 * 3, (i + 1) * 75 + offset, width / 4 * 3, 75 + (i + 1) * 75 + offset);
      line(width / 8 * 5, (i + 1) * 75 + offset, width / 8 * 5, 75 + (i + 1) * 75 + offset);
      line(width / 16 * 11, (i + 1) * 75 + offset, width / 16 * 11, 75 + (i + 1) * 75 + offset);
      line(width / 8 * 7, (i + 1) * 75 + offset, width / 8 * 7, 75 + (i + 1) * 75 + offset);
      if (mousePressed && mouseButton == RIGHT && mouseX > width / 2 && mouseX < width && mouseY > (i + 1) * 75 + offset && mouseY < (i + 1) * 75 + offset + 75) {
        openMenu = true;
        clickIndex = i;
      }
      textAlign(CENTER, CENTER);
      textSize(15);
      fill(0);
      noStroke();
      text(e.date, width / 2, (i + 1) * 75 + offset, width / 8, 75);
      textSize(12);
      text(e.time, width / 8 * 5, (i + 1) * 75 + offset, width / 16, 75);
      textSize(15);
      text(e.code, width / 16 * 11, (i + 1) * 75 + offset, width / 16, 75);
      textSize(13);
      text(e.title, width / 4 * 3, (i + 1) * 75 + offset, width / 8, 75);
      textSize(15);
      text(e.venue, width / 8 * 7, (i + 1) * 75 + offset, width / 8, 75);
    }
  }
  stroke(0);
  strokeWeight(3);
  fill(220);
  rect(width / 2, 0, width / 2, 75);
  line(width / 4 * 3, 0, width / 4 * 3, 75);
  line(width / 8 * 5, 0, width / 8 * 5, 75);
  line(width / 16 * 11, 0, width / 16 * 11, 75);
  line(width / 8 * 7, 0, width / 8 * 7, 75);
  textAlign(CENTER, CENTER);
  textSize(20);
  fill(0);
  noStroke();
  text("Date", width / 16 * 9, 36);
  text("Time", width / 32 * 21, 36);
  text("Module Code", width / 16 * 11, 0, width / 16, 75);
  text("Module Title", width / 16 * 13, 36);
  text("Venue", width / 16 * 15, 36);
  if (openMenu) {
    fill(150);
    stroke(0);
    rect(width / 2 - 100, (clickIndex + 1) * 75 + offset, 100, 50);
    fill(0);
    noStroke();
    text("Remove", width / 2 - 50, (clickIndex + 1) * 75 + offset + 22);
    if (mousePressed && (mouseX > width / 2 - 100 && mouseX < width / 2 && mouseY > (clickIndex + 1) * 75 + offset && mouseY < (clickIndex + 1) * 75 + offset + 50)) {
      Exam[] temp = new Exam[80];
      for (int i = 0; i < currentExams.length - 1; i++) {
        if (i < clickIndex) temp[i] = currentExams[i];
        else temp[i] = currentExams[i + 1];
      }
      currentExams = temp;
      openMenu = false;
    }
  }
  if (mousePressed && (mouseX < width / 2 || mouseY < 75)) openMenu = false;
  pop();
}

public void mousePressed() {
  if (popUpOpen) {
    confirmModule.clicked();
    moduleSelect.clicked();
  } else {
    yearSelect.clicked();
    addModule.clicked();
    saveExams.clicked();
  }
}

public void showPopUp() {
  push();
  fill(0, 150);
  noStroke();
  rect(0, 0, width, height);
  stroke(0);
  strokeWeight(3);
  fill(255);
  rect(50, 50, width - 100, height - 100);
  if (loadImages) {
    
  }
  moduleSelect.show();
  confirmModule.show();
  pop();
}

class Button {
  float x, y, w, h;
  String txt, id;
  Button(float x_, float y_, float w_, float h_, String t, String i) {
    x = x_;
    y = y_;
    w = w_;
    h = h_;
    txt = t;
    id = i;
  }

  public void show() {
    push();
    fill(255);
    stroke(0);
    if (mouseX < x + w / 2 && mouseX > x - w / 2 && mouseY < y + h / 2 && mouseY > y - h / 2) strokeWeight(5);
    else strokeWeight(3);
    rectMode(CENTER);
    rect(x, y, w, h);
    noStroke();
    fill(0);
    textAlign(CENTER, CENTER);
    textSize(20);
    text(txt, x, y - 3, w, h);
    pop();
  }

  public void clicked() {
    if (mouseX < x + w / 2 && mouseX > x - w / 2 && mouseY < y + h / 2 && mouseY > y - h / 2) {
      if (id == "addModule") {
        popUpOpen = true;
      }
      if (id == "confirmModule") {
        int len = 0;
        for (Exam exam : currentExams) {
          if (exam != null) len++;
        }
        Exam selected = exams[moduleSelect.selectedIndex];
        boolean contains = false;
        for (Exam exam : currentExams) {
          if (exam == selected) {
            contains = true;
          }
        }
        if (!moduleSelect.open && !contains) {
          currentExams[len] = exams[moduleSelect.selectedIndex];
        }
        popUpOpen = false;
        offset = 0;
      }
      if (id == "saveExams") {
        int i = 0;
        for (Exam e : currentExams) {
          if (e != null) {
            JSONObject exam = new JSONObject();
            exam.setString("code", e.code);
            exam.setString("date", e.date);
            exam.setString("time", e.time);
            exam.setString("title", e.title);
            exam.setString("venue", e.venue);
            savedExams.setJSONObject(i, exam);
            i++;
          }
        }
        saveJSONArray(savedExams, "data/savedExams.json");
        showing = true;
        timer = 3;
      }
    }
  }
}

class Dropdown {
  float x, y, w, h;
  String[] options;
  String state, prevState;
  boolean open = false;
  boolean onButton = false;
  int selectedIndex = 0;
  int maxBoxes;
  int ownOffset = 0;
  String id;
  Dropdown(float x_, float y_, float w_, float h_, String[] o, int m, String i) {
    x = x_;
    y = y_;
    w = w_;
    h = h_;
    options = o;
    state = o[0];
    maxBoxes = m;
    id = i;
  }

  public void show() {
    push();
    stroke(0);
    if (mouseX < x + w / 2 && mouseX > x - w / 2 && mouseY < y + h / 2 && mouseY > y - h / 2) strokeWeight(5);
    else strokeWeight(3);
    fill(255);
    rectMode(CENTER);
    rect(x, y, w, h);
    fill(0);
    noStroke();
    textSize(min(w, h) / 2);
    textAlign(CENTER, CENTER);
    text(state, x - h / 3, y - 3);
    float arrowX = x + w / 2 - 20;
    fill(255);
    stroke(0);
    strokeWeight(3);
    line(arrowX - 5, y, arrowX, y + 5);
    line(arrowX, y + 5, arrowX + 5, y);
    boolean onAnyButton = false;
    if (open) {
      for (int i = 0; i < maxBoxes; i++) {
        if (mouseX < x + w / 2 && mouseX > x - w / 2 && mouseY < y + (i + 1) * h + h / 2 && mouseY > y + (i + 1) * h - h / 2) {
          fill(0, 204, 204);
          onButton = true;
          onAnyButton = true;
          selectedIndex = i + ownOffset;
        } else {
          fill(255);
        }
        stroke(0);
        strokeWeight(3);
        rect(x, y + (i + 1) * h, w, h);
        fill(0);
        noStroke();
        text(options[i + ownOffset], x - h / 3, y - 3 + (i + 1) * h);
      }
      if (onAnyButton == false) {
        onButton = false;
      }
    }
    pop();
  }

  public void clicked() {
    if (open) {
      if (mouseX < x + w / 2 && mouseX > x - w / 2 && mouseY < y + (options.length + 1) * h + h / 2 && mouseY > y - h / 2) {
        if (onButton) {
          prevState = state;
          state = options[selectedIndex];
        }
      }
      int year = yearSelect.state.charAt(5) - 48;
      int i = 0;
      currentExams = new Exam[80];
      for (Exam exam : exams) {
        if (exam.code.charAt(2) - 48 == year) {
          currentExams[i] = exam;
          i++;
        }
      }
      open = false;
      offset = 0;
      onButton = false;
    }
    if (mouseX < x + w / 2 && mouseX > x - w / 2 && mouseY < y + h / 2 && mouseY > y - h / 2) {
      if (!open) open = true;
    }
  }
}

class Exam {
  String code, date, time, title, venue;
  Exam(String c, String d, String t, String mt, String v) {
    code = c;
    date = d;
    time = t;
    title = mt;
    venue = v;
  }
}
  public void settings() {  size(1280, 720); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "hackathon" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
