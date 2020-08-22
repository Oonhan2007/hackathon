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

  void show() {
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

  void clicked() {
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
