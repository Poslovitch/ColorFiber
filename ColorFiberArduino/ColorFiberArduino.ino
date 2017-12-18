/*
 * This code has been redacted by Poslovitch, known as CUNY Florian,
 * who lives in the best country in the world, but who would care of that?
 * 
 * This code is heavily inspired and based on the example code "ReadASCIIString", created 13 Apr 2012 by Tom Igoe.
 * 
 * Created 04 Dec 2017
 * by Florian CUNY
 */

// Select the mode of the program
enum mode {
  output,
  input
};
const mode mode = output;

// Constants of the pins
const int redPin = 3;
const int greenPin = 5;
const int bluePin = 6;

void setup() {
  if(mode == output) {
    // Setup the LED pins in output mode
    pinMode(redPin, OUTPUT);
    pinMode(greenPin, OUTPUT);
    pinMode(bluePin, OUTPUT);

    // Initialize the serial connection
    Serial.begin(57600);
  }
  else if(mode == input) {
    
  }
}

void loop() {
  if(mode == output) {
    if(Serial.available() > 0) {
      // get each value separated by a space
      int red = Serial.parseInt();
      int green = Serial.parseInt();
      int blue = Serial.parseInt();

      // Look for newline. = end of order
      if (Serial.read() == '\n') {
        // Write the values to the corresponding pins
        analogWrite(redPin, red);
        analogWrite(greenPin, green);
        analogWrite(bluePin, blue);
      }
    }
  }
  else if(mode == input) {
  }
}

