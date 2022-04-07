package logs;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class FiltroSoloMultiplicar implements Filter {

	@Override
	public boolean isLoggable(LogRecord record) {
		boolean guardarLog = false;
		
		if (record.getMessage() != null && record.getMessage().contains("*")) {
			guardarLog = true;
		}
		
		return guardarLog;
	}

}
