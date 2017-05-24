package adv;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class ReadExcelFile {
	public static String[][][] read(String fileName) {
		Workbook workbook = null;
		try {
			WorkbookSettings ws = new WorkbookSettings();
			ws.setGCDisabled(true);
			workbook = Workbook.getWorkbook(new File(fileName), ws);

			int sheetCount = workbook.getNumberOfSheets();
			// String[] sheetNames = workbook.getSheetNames();

			// ���o�����̃f�[�^��z��Ɋi�[
			String[][][] result = new String[sheetCount][][];
			for (int i = 0; i < sheetCount; i++) {
				Sheet sheet = workbook.getSheet(i);
				result[i] = new String[sheet.getRows()][sheet.getColumns()];
				for (int j = 0; j < sheet.getRows(); j++) { // �V�[�g�̎n�� N�s
															// ��ǂݔ�΂��������́Aj=N
															// �Ƃ���
					for (int k = 0; k < sheet.getColumns(); k++) { // �V�[�g�̎n�� N��
																	// ��ǂݔ�΂��������́Ak=N
																	// �Ƃ���
						Cell cell = sheet.getCell(k, j);
						result[i][j][k] = cell.getContents();
					}
				}
				// result[i][0][0] = sheetNames[i]; //A��1�s�ڂɃV�[�g�����i�[
			}
			return result;
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				workbook.close();
			}
		}
		return null;
	}

}
