module repro {
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.databind;

  exports repro;
  exports repro2;

  opens repro2;
}
