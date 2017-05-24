package adv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CreateGexf {

	public static void writeGexf(String gexfFileName, String[][] NL, String[][] EL, ArrayList<String> nodeID) {

		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(gexfFileName)));

			pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.println("<gexf xmlns=\"http://www.gexf.net/1.2draft\" " + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + "xsi:schemaLocation=\"http://www.gexf.net/1.2draft http://www.gexf.net/1.2draft/gexf.xsd\" version=\"1.2\">");
			pw.println("<graph mode=\"static\" defaultedgetype=\"directed\">");
			// pw.println("<attributes class=\"node\">");
			// pw.println("<attribute id=\"0\" title=\"region\" type=\"string\"/>");
			// pw.println("</attributes>");
			pw.println("<nodes>");
			for (int i = 0; i < NL.length - 1; i++) {
				pw.println("<node id=\"" + i + "\" label=\"" + NL[i + 1][1] + "\"/>"); // 1行目のラベルは除くため、i+1とする
				// pw.println("<attvalues>");
				// pw.println("<attvalue for=\"0\" value=\"" + NL[i + 1][3] +
				// "\"/>");
				// pw.println("</attvalues>");
			}
			pw.println("</nodes>");
			pw.println("<edges>");
			for (int j = 0; j < EL.length - 1; j++) {
				pw.println("<edge id=\"" + j + "\" source=\"" + nodeID.indexOf(EL[j + 1][0]) + "\" target=\"" + nodeID.indexOf(EL[j + 1][1]) + "\" weight=\"" + EL[j + 1][2] + "\"/>"); // sourceとtargetにはノードのidを指定(labelではない)
			}
			pw.println("</edges>");
			pw.println("</graph>");
			pw.println("</gexf>");
			pw.close();
			System.out.println("書き込み成功");
		} catch (IOException e) {
			System.out.println("書き込み失敗");
		}

	}

}
