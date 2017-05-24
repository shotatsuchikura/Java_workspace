
public class KinnyuuKougaku {
	public static void main(String args[]){	
		
		double[] myu = new double[7];
		double[] w = new double[7];
		double[] minw = new double[7];
		double[][] sigma = new double[7][7];
		double ritoku = 0;
		double risk = 0;
		double minrisk = 1000000;
		
		myu[1] = -0.00047108;
		myu[2] = -0.00125759;
		myu[3] = -0.000905754;
		myu[4] = -0.002203928;
		myu[5] = 0.000240992;
		myu[6] = 0.000603823;
		
		sigma[1][1] = 0.000416857;
		sigma[1][2] = 0.000287198;
		sigma[1][3] = 0.00028482;
		sigma[1][4] = 0.000285815;
		sigma[1][5] = 0.000252544;
		sigma[1][6] = 0.00030542;
		sigma[2][1] = sigma[1][2];
		sigma[2][2] = 0.000480518;
		sigma[2][3] = 0.000390561;
		sigma[2][4] = 0.000387424;
		sigma[2][5] = 0.000291173;
		sigma[2][6] = 0.000300703;
		sigma[3][1] = sigma[1][3];
		sigma[3][2] = sigma[2][3];
		sigma[3][3] = 0.000557513;
		sigma[3][4] = 0.000438696;
		sigma[3][5] = 0.000255035;
		sigma[3][6] = 0.000304133;
		sigma[4][1] = sigma[1][4];
		sigma[4][2] = sigma[2][4];
		sigma[4][3] = sigma[3][4];
		sigma[4][4] = 0.000684531;
		sigma[4][5] = 0.00027415;
		sigma[4][6] = 0.000318603;
		sigma[5][1] = sigma[1][5];
		sigma[5][2] = sigma[2][5];
		sigma[5][3] = sigma[3][5];
		sigma[5][4] = sigma[4][5];
		sigma[5][5] = 0.000322181;
		sigma[5][6] = 0.000245254;
		sigma[6][1] = sigma[1][6];
		sigma[6][2] = sigma[2][6];
		sigma[6][3] = sigma[3][6];
		sigma[6][4] = sigma[4][6];
		sigma[6][5] = sigma[5][6];
		sigma[6][6] = 0.000590515;
		
		//System.out.println(myu[1]);
		
		System.out.println("Start some Caluculation!");
		System.out.println("result");
		System.out.println("return,risk");
		//for(int r = 0; r<61; r++){						//ritoku ‚ð‚Ü‚í‚·‚Æ‚«
			//ritoku = r*1.0E-5;							//ã‚É“¯‚¶
		ritoku = 0;									//ritoku‚ðŒÅ’è‚·‚é‚Æ‚«
			for(int i1 = 0; i1<101; i1++){
				w[1] = (double)(i1)/100.0;
				//System.out.println(w[1]);
				for(int i2 = 0; i2<101; i2++){
					w[2] = (double)(i2)/100.0;
					for(int i3 = 0; i3<101; i3++){
						w[3] = (double)(i3)/100.0;
						for(int i4 = 0; i4<101; i4++){
							w[4] = (double)(i4)/100.0;
							w[5] = ((ritoku-myu[6])+(myu[6]-myu[1])*w[1]+(myu[6]-myu[2])*w[2]+(myu[6]-myu[3])*w[3]+(myu[6]-myu[4])*w[4])/(myu[5]-myu[6]);
							w[6] = ((ritoku-myu[5])+(myu[5]-myu[1])*w[1]+(myu[5]-myu[2])*w[2]+(myu[5]-myu[3])*w[3]+(myu[5]-myu[4])*w[4])/(myu[6]-myu[5]);
							if(w[5]>=0 && w[6]>=0){
								for(int a = 1; a<7; a++){
									for(int b = 1; b<7; b++){
										risk = risk + w[a]*w[b]*sigma[a][b];
									}
								}
								if(risk<minrisk){
									minrisk = risk;
									for(int i = 1; i<7; i++){
										minw[i] = w[i];
									}
								}
								risk = 0;
							}						
						}
					}
				}
			}			
			System.out.println(ritoku+","+minrisk);
			for(int j=1; j<7; j++){
				System.out.println(minw[j]);
			}
			minrisk = 100000;
		//}												//ritoku‚ð‚Ü‚í‚·‚Æ‚«

	}


}
