/**
 * 并查集，判断连通性
 */
public class UF {
    private int count;
    private int[] parent;

    public UF(int n){
        this.count=n;
        parent=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
    }
    // 将两点连接
    public void union(int p,int q){
        int rootP=find(p);
        int rootQ=find(q);

        if(rootP==rootQ){
            return;
        }
        parent[rootQ]=rootP;
        count--;
    }
    // 判断两点是否连接
    public boolean connected(int p,int q){
        int rootP=find(p);
        int rootQ=find(q);
        return rootP==rootQ;
    }

    // 路径压缩方法
    // 将整个树压平，只有两层，一个根节点，和其他节点，除了根节点其他都在第二层
    // 返回某个节点的根节点
    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    // 路径压缩方法
    public int find1(int x){
        // 将一对父子节点改到同一层
        while(parent[x]!=x){
            parent[x]=parent[parent[x]];
            x=parent[x];
        }
        return x;
    }
    // 返回有多少连通分量
    public int count(){
        return count;
    }
}

    /**
     * class UF{
     *     private int count;
     *     private int[] parent;
     *     // 新增size数组来平衡树
     *     private int[] size;
     *
     *     public UF(int n){
     *         this.count=n;
     *         parent=new int[n];
     *         size=new int[n];
     *         for(int i=0;i<n;i++){
     *          parent[i]=i;
     *          size[i]=1;
     *          }
     *     }
     *          // 改写union方法
     *         public void union(int p,int q){
     *         int rootP=find(p);
     *         int rootQ=find(q);
     *
     *         if(rootP==rootQ){
     *             return;
     *         }
     *         // 判断两个需要连接树的size
     *         if(size[rootP]>size[rootQ]){
     *         parent[rootQ]=rootP;
     *         size[rootP]+=size[rootQ];
     *          }
     *         else{
     *         parent[rootP]=rootQ;
     *         size[rootQ]+=size[rootP];
     *          }
     *          count--;
     *     }
     *     }
     */

