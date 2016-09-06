package mike.innerinterface;

/**
 * Created by Devin on 8/23/2016.
 */
public class InnerInterface {

    public interface View{
        void view();
    }

    private interface Repaire extends View{
        void repaire();
    }

    public class TV implements Repaire{
        private TV(){
        }
        @Override
        public void view() {
            System.out.println("The user is watching TV");
        }

        @Override
        public void repaire() {
            System.out.println("The factory repaire the TV");
        }
    }

    public View getView(){
        return new TV();
    }

    public void repaire(View view){
        Repaire repaire = (Repaire)view;
        repaire.repaire();
    }
}
