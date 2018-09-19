package struct;

public class GraphicMatrix {
	//定点集合
	char[] vertex = new char[]{'A','B','C','D'};
	//是否是无向图 0 无向 1 有向
	int GType = 0;
	//顶点的数量
	int VertexNum = 4;
	//边的数量
	int EdgeNum = 6;
	//边的权重
	int[][] EdgeWeight = new int[][]{{0,3,1,1}, {3,0,2,2}, {1,2,0,1},{1,2,1,0}};
	//是否遍历过该点
	int[] isTrav = new int[4];

}
