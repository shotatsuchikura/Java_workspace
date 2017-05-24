package adv;

import java.util.ArrayList;

public class Analyze {

	public static void main(String[] args) {
		String FileName = "/Users/shota_tsuchikura/Desktop/comtrade/2009total.xls";
		String gexfFileName = "2009.gexf";

		String[][][] List = ReadExcelFile.read(FileName);

		String[][] NL = trs(List, 0);
		String[][] EL = trs(List, 1);

		/* edgeListのsourceとtargetが(idでなく)ノード名の場合、gexfを書く際に必要な「ノードidリスト」を作成 */
		ArrayList<String> nodeID = new ArrayList<String>();
		for (int j = 0; j < NL.length - 1; j++) {
			nodeID.add(NL[j + 1][1]);
		}

		CreateGexf.writeGexf(gexfFileName, NL, EL, nodeID);

	}

	// 3次元配列(list)のシート番号nの要素を抜き出して2次元配列に変換するメソッド
	public static String[][] trs(String[][][] list, int n) {
		int column = list[n][0].length;
		int row = list[n].length;
		String[][] two_D = new String[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				two_D[i][j] = list[n][i][j];
			}
		}
		return two_D;
	}

}
