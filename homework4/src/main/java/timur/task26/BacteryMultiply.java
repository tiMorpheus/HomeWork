package timur.task26;

import java.util.ArrayList;
import java.util.List;

public class BacteryMultiply {

    List<Bacterium> list = new ArrayList<>();

    public List<Bacterium> getList() {
        return list;
    }

    public List<Bacterium> multiplyBacterium(int countOfGeneration) {
        for (int i = 0; i < countOfGeneration; i++) {
            int random = (int) (Math.random() * 10);

            switch (random) {
                case 1:
                    list.add(BacteriumFactory.getBacterium(Form.CHAIN_OF_BACILLI));
                    break;
                case 2:
                    list.add(BacteriumFactory.getBacterium(Form.CHAIN_OF_COCCI));
                    break;
                case 3:
                    list.add(BacteriumFactory.getBacterium(Form.CLUSTER_OF_COCCI));
                    break;
                case 4:
                    list.add(BacteriumFactory.getBacterium(Form.COMMA));
                    break;
                case 5:
                    list.add(BacteriumFactory.getBacterium(Form.CORKSCREW));
                    break;
                case 6:
                    list.add(BacteriumFactory.getBacterium(Form.ROD));
                    break;
                default:
                    list.add(BacteriumFactory.getBacterium(Form.SPIRAL));
            }
        }

        return list;
    }
}
