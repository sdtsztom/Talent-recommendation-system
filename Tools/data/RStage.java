package ienum;

public enum RStage{
	FINISH,W_SIFT,W_I1,W_I2,W_OC,W_TW,W_ARR_S,W_ARR_I1;

	@Override
	public String toString(){
		String s=null;
		switch(this){
			case FINISH:{s="结束";break;}
			case W_SIFT:{s="等待筛选";break;}
			case W_I1:{s="等待初轮面试";break;}
			case W_I2:{s="等待最终面试";break;}
			case W_OC:{s="等待offer确认";break;}
			case W_TW:{s="等待入职";break;}
			case W_ARR_S:{s="等待安排(筛选后)";break;}
			case W_ARR_I1:{s="等待安排(初轮面试后)";break;}
		}
		return s;
	}

	public int toId(){
		int id=-1;
		switch(this){
			case FINISH:{id=1;break;}
			case W_SIFT:{id=2;break;}
			case W_I1:{id=3;break;}
			case W_I2:{id=4;break;}
			case W_OC:{id=5;break;}
			case W_TW:{id=6;break;}
			case W_ARR_S:{id=7;break;}
			case W_ARR_I1:{id=8;break;}
		}
		return id;
	}

}