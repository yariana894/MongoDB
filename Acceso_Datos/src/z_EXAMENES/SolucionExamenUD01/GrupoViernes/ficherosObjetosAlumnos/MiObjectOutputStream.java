package z_EXAMENES.SolucionExamenUD01.GrupoViernes.ficherosObjetosAlumnos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {

	public MiObjectOutputStream(OutputStream out) throws SecurityException, IOException {
		super(out);
		
	}
	protected void writeStreamHeader() {
		
	}

}
