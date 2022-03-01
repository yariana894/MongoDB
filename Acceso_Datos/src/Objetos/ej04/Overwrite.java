package Objetos.ej04;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class Overwrite extends ObjectOutputStream {

    public Overwrite(OutputStream out) throws IOException {
        super(out);
    }

    protected Overwrite() throws IOException, SecurityException {
    }

    public void writeStreamHeader() {
    }
}