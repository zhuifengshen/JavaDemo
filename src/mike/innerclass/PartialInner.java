package mike.innerclass;

/**
 * Created by Devin on 2016/7/14.
 */
public class PartialInner {
    public Destination123 destiantion(String string){
        //方法内使用内部类
        class SubDestiantion implements Destination123{
            private String label;
            private SubDestiantion(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                System.out.println(label);
                return label;
            }
        }
        return new SubDestiantion(string);
    }

    private void internalTracking(boolean b){
        if(b){
            //if作用域中使用内部类
            class TrackingSlip{
                private String id;
                TrackingSlip(String s){
                    id = s;
                }
                String getSlip(){
                    return  id;
                }
            }
            TrackingSlip trackingSlip = new TrackingSlip("devin");
            System.out.println(trackingSlip.getSlip());
        }
    }
    public void track(){
        internalTracking(true);
    }

    public static void main(String[] args){
        PartialInner partialInner = new PartialInner();
        Destination123 destination123 = partialInner.destiantion("youmi");
        destination123.readLabel();

        partialInner.track();
    }
}

interface Destination123{
    String readLabel();
}