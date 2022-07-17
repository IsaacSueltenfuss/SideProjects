#include <Wire.h>
#include "SparkFunMPL3115A2.h"

MPL3115A2 myPressure;

// Sets the port on the Arduino UNO for the compressor to be 8 (this value can change)
int outputPort = 8;
// Sets a threshold for the barometer to check pressure against
float pressureMaximum = 100000;

void setup() {
  Wire.begin();
  Serial.begin(9600);
  pinMode(outputPort, OUTPUT);

  myPressure.begin();

  myPressure.setModeBarometer();

  myPressure.setOversampleRate(7);
  myPressure.enableEventFlags();
}

void loop() {
  // Assigns value to be current pressure (in Pascals)
  float pressure = myPressure.readPressure();

  // Uploads current pressure reading to the Serial Monitor
  Serial.print("Pressure (Pa):");
  Serial.println(pressure, 2);

  // If the current pressure is less than a certain amount of Pascals, then it will send power to the outputPort (for the compressor)
  if (pressure < pressureMaximum) {
    digitalWrite(outputPort, HIGH);
  }
  // Otherwise, if the current pressure is at or above that certain amount it will turn off the compressor
  else {
    digitalWrite(outputPort, LOW);
  }
}
