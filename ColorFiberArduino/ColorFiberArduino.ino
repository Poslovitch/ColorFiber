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
const int redPin = 6;
const int greenPin = 5;
const int bluePin = 3;

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
    pinMode(A0, INPUT);
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
        // Look for values askng for a debug
        if (red == -42) {
          testOutput();
          return;
        }
        // Write the values to the corresponding pins
        analogWrite(redPin, red);
        analogWrite(greenPin, green);
        analogWrite(bluePin, blue);

        // On print un débug des données reçues et renvoyées aux pins.
        Serial.print("Received: r=");
        Serial.print(red);
        Serial.print(" g=");
        Serial.print(green);
        Serial.print(" b=");
        Serial.println(blue);
      }
    }
  }
  else if(mode == input) {
    
  }
}

void testOutput() {
  Serial.println("Testing output");
  for(int i = 0; i < 50; i++) {
    int red = random(0, 255);
    int green = random(0, 255);
    int blue = random(0, 255);
    analogWrite(redPin, red);
    analogWrite(greenPin, green);
    analogWrite(bluePin, blue);
    // On print un débug des données reçues et renvoyées aux pins.
    Serial.print("DEBUG: r=");
    Serial.print(red);
    Serial.print(" g=");
    Serial.print(green);
    Serial.print(" b=");
    Serial.println(blue);
    delay(10);
    analogWrite(redPin, 0);
    analogWrite(greenPin, 0);
    analogWrite(bluePin, 0);
    delay(40);
  }
}

