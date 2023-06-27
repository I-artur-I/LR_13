package task_1;

import java.util.Scanner;

abstract class HorseHairBrush {
    public abstract void produce();
}

abstract class MooseHairBrush {
    public abstract void produce();
}

abstract class DogHairBrush {
    public abstract void produce();
}

abstract class BrushFactory {
    public abstract HorseHairBrush createHorseHairBrush();
    public abstract MooseHairBrush createMooseHairBrush();
    public abstract DogHairBrush createDogHairBrush();
}

class ArtistBrushFactory extends BrushFactory {
    @Override
    public HorseHairBrush createHorseHairBrush() {
        return new ArtistHorseHairBrush();
    }

    @Override
    public MooseHairBrush createMooseHairBrush() {
        return new ArtistMooseHairBrush();
    }

    @Override
    public DogHairBrush createDogHairBrush() {
        return new ArtistDogHairBrush();
    }
}

class PainterBrushFactory extends BrushFactory {
    @Override
    public HorseHairBrush createHorseHairBrush() {
        return new PainterHorseHairBrush();
    }

    @Override
    public MooseHairBrush createMooseHairBrush() {
        return new PainterMooseHairBrush();
    }

    @Override
    public DogHairBrush createDogHairBrush() {
        return new PainterDogHairBrush();
    }
}

class VisagisteBrushFactory extends BrushFactory {
    @Override
    public HorseHairBrush createHorseHairBrush() {
        return new VisagisteHorseHairBrush();
    }

    @Override
    public MooseHairBrush createMooseHairBrush() {
        return new VisagisteMooseHairBrush();
    }

    @Override
    public DogHairBrush createDogHairBrush() {
        return new VisagisteDogHairBrush();
    }
}

class ArtistHorseHairBrush extends HorseHairBrush {
    @Override
    public void produce() {
        System.out.println("Производство кисточки из лошадиного волоса для художника");
    }
}

class ArtistMooseHairBrush extends MooseHairBrush {
    @Override
    public void produce() {
        System.out.println("Производство кисточки из лосиного волоса для художника");
    }
}

class ArtistDogHairBrush extends DogHairBrush {
    @Override
    public void produce() {
        System.out.println("Производство кисточки из собачьего волоса для художника");
    }
}

class PainterHorseHairBrush extends HorseHairBrush {
    @Override
    public void produce() {
        System.out.println("Производство кисточки из лошадиного волоса для моляра");
    }
}

class PainterMooseHairBrush extends MooseHairBrush {
    @Override
    public void produce() {
        System.out.println("Производство кисточки из лосиного волоса для моляра");
    }
}

class PainterDogHairBrush extends DogHairBrush {
    @Override
    public void produce() {
        System.out.println("Производство кисточки из собачьего волоса для моляра");
    }
}

class VisagisteHorseHairBrush extends HorseHairBrush {
    @Override
    public void produce() {
        System.out.println("Производство кисточки из лошадиного волоса для визажиста");
    }
}

class VisagisteMooseHairBrush extends MooseHairBrush {
    @Override
    public void produce() {
        System.out.println("Производство кисточки из лосиного волоса для визажиста");
    }
}

class VisagisteDogHairBrush extends DogHairBrush {
    @Override
    public void produce() {
        System.out.println("Производство кисточки из собачьего волоса для визажиста");
    }
}

public class Main {
    public static void main(String[] args) {
        BrushFactory factory;
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Выберите для кого производить кисти (художник, маляр, визажист):");
            String category = scan.next();

            if (category.equalsIgnoreCase("художник")) {
                factory = new ArtistBrushFactory();
                break;
            } else if (category.equalsIgnoreCase("маляр")) {
                factory = new PainterBrushFactory();
                break;
            } else if (category.equalsIgnoreCase("визажист")) {
                factory = new VisagisteBrushFactory();
                break;
            } else {
                System.out.println("Некорректная категория продукта");
            }
        }

        HorseHairBrush horseHairBrush = factory.createHorseHairBrush();
        horseHairBrush.produce();

        MooseHairBrush mooseHairBrush = factory.createMooseHairBrush();
        mooseHairBrush.produce();

        DogHairBrush dogHairBrush = factory.createDogHairBrush();
        dogHairBrush.produce();
    }
}