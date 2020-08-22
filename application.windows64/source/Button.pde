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

  void show() {
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

  void clicked() {
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
