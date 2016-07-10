package com.kostas.fortunecookie;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int position;

    final private String[] sayingAnc = {
            "1Ζώον δίπουν άπτερον",
            "2Μη εκ λόγων τα πράγματα, αλλ' εκ των πραγμάτων τους λόγους ζητείν.",
            "3Τι εστιν ό μίαν έχον φωνήν τετράπουν και δίπουν και τρίπουν γίνεται;",
            "4Φύσει γαρ άνθρωπος, ό βούλεται, τούτο και οίεται.",
            "5Πολέμιον ανθρώποις αυτοί εαυτοίς.",
            "6Πάντες άνθρωποι φύσει ορέγονται του ειδέναι.",
            "7Άνθρωπον ζητώ.",
            "8Μέμνησο ότι άνθρωπος εί.",
            "9Ως χαρίεν εστ’ άνθρωπος αν άνθρωπος ή.",
            "10Σκιάς όναρ άνθρωπος.",
            "11Πολλά τα δεινά κουδέν ανθρώπου δεινότερον πέλει.",
            "12Ουκ ένι ιατρικήν είδέναι, όστις μη οίδεν ό τι εστίν άνθρωπος.",
            "13Άπαξ άνθρωποι γεγόναμεν, δις δε ουκ έστι γενέσθαι.",
            "14Θνητός γεγονώς άνθρωπε, μη φρόνει μέγα.",
            "15Πρώτον μεν γαρ τρία ην τα γένη τα των ανθρώπων, ουχ ώσπερ νυν δύο.",
            "16Άνθρωπος τελειωθείς βέλτιστον των ζώων, χωρισθέν δε νόμου και δίκης, χείριστον πάντων.",
            "17Του ανθρωπίνου βίου ο μεν χρόνος στιγμή, η δε ουσία ρέουσα, η δε αίσθησις αμυδρά, η δε " +
                    "όλου του σώματος σύγκρισις εύσηπτος, η δε ψυχή ρόμβος, η δε τύχη δυστέκμαρτον, η δε φήμη άκριτον.",
            "18Κάλλιστον κόσμος, ποίημα γαρ θεού.",
            "19Κόσμον τονδε, τον αυτόν απάντων, ούτε τις θεών ούτε ανθρώπων εποίησεν, αλλ' ην αεί και έστιν και έστε πύρ αείζωον.",
            "20Σκηνή πας ο κόσμος εστί και παίγνιον· ή μάθε παίζειν ή φέρε τας οδύνας.",
            "21Τοις εγρηγορόσιν ένα και κοινόν κόσμον είναι, των δε κοιμωμένων έκαστον εις ίδιον αποστρέφεσθαι.",
            "22Πάντων χρημάτων μέτρον άνθρωπος.",
            "23Ο αναθρών ά όπωπε.",
            "24Σκιάς όναρ άνθρωπος.",
            "25Ουκ ένι ιατρικήν είδέναι, όστις μη οίδεν ό τι εστίν άνθρωπος.",
            "26Γυμνοί ήλθομεν οι πάντες, γυμνοί και απελευσόμεθα.",
            "27Θνητός γεγονώς άνθρωπε, μη φρόνει μέγα.",
            "28Ουδέν κακόν αμιγές καλού.",
            "29Αισχρόν το γ’ αισχρόν, καν δοκή καν μη δοκή.",
            "30Πη παρέβην; Τι δ’ έρεξα;Τι δε μοι δέον ουκ ετελέσθη;",
            "31Ανοήμονες βιούσι ού τερπόμενοι βιούν.",
            "32Τον βίον μη, τω χρόνω βραχύν όντα, πράγμασιν κακοίς μακρόν ποιείν.",
            "33Ο κόσμος αλλοίωσις, ο βίος υπόληψις.",
            "34Άνθρωποι βίου δεόμενοι, πολλά και παντοία τεχνέονται.",
            "35Μέτρον βίου το καλόν ου το του χρόνου μήκος.",
            "36Βραχύς αιών.",
            "37Θνητών όλβιος εις το τέλος ουδείς.",
            "38Έξω του κόσμου το αποθανόν ου πίπτει.",
            "39Ο θάνατος τυγχάνει ων, ως εμοί δοκεί, ουδέν άλλο ή δυοίν πραγμάτοιν διάλυσις, της ψυχής και του σώματος απ' αλλήλου.",
            "40Ύπνω και θανάτω διδυμάοσιν.",
            "41Κοινωνία γαρ ψυχή και σώματι διαλύσεως ουκ έστιν η κρείττον.",
            "42Πολλά λαλείς, άνθρωπε, χαμαί δε τίθη μετά μικρόν. Σίγα, και μελέτα ζών έτι τον θάνατον.",
            "43Άρα μη θανόντες τώ δοκείν ζώμεν μόνον," +
                    "Έλληνες άνδρες, συμφορά πεπτωκότες" +
                    "όνειρον εικάζοντες είναι τόν βίον;" +
                    "ή ζώμεν ημείς, τού βίου τεθνηκότος;",
            "44Θανέειν πέπρωται άπασι.",
            "45Εισί γάρ δή οι περί τάς τελετάς ναρθηκοφόροι μέν πολλοί, βάκχοι δε τε παύροι.",
            "46Πάντα γαρ φύσει έχει τι θείον.",
            "47Περί μεν θεών ουκ έχω ειδέναι, ούθ’ ως εισίν ουθ’ ως ουκ εισίν.",
            "48Θεός ουδαμή ουδαμώς άδικος.",
            "49Θεοί μεν γαρ εισίν. Εναργής γαρ αυτών εστιν η γνώσις.",
            "50Τοις θεοίς τίθει τα πάντα.",
            "51Έσσετ’ ήμαρ.",
            "52Οι καιροί ου μενετοί.",
            "53Πάντα εκκαλύπτων ο χρόνος εις το φως άγει.",
            "54Από κύλικος μέχρι χειλέων πολλά πέλει.",
            "55Όμοια γάρ ως επί το πολύ τα μέλλοντα τοις γεγονόσι.",
            "56Άμες γ’ εσόμεθα πολλώ κάρρονες.",
            "57Μέμνησο νέος ων, ως γέρων έση ποτέ.",
            "58Αετού γήρας κορύδου νεότης.",
            "59Αμές ποκ’ ήμες άλκιμοι νεανίαι."

    };

    final private String[] sayingGr = {
            "1Ζώο δίποδο χωρίς φτερά",
            "2Δεν πρέπει να ερευνούμε τα γεγονότα ξεκινώντας από τις αιτίες, αλλά τις αιτίες ξεκινώντας από τα γεγονότα",
            "3Τι έχει 4 πόδια, μετά 2 πόδια και μετά 3;",
            "4Από τη φύση του ο άνθρωπος, αυτό που θέλει, αυτό νομίζει",
            "5Ο εχθρός του ανθρώπου είναι ο ίδιος εαυτός του",
            "6Όλοι οι άνθρωποι έχουν από τη φύση τους έφεση για γνώση.",
            "7Ζήτω ο άνθρωπος!",
            "8Να θυμάσαι ότι είσαι άνθρωπος.",
            "9Πόσο ωραίο πράγμα είναι ο άνθρωπος όταν είναι άνθρωπος ",
            "10Το όνειρο της σκιάς είναι ο άνθρωπος",
            "11",
            "12",
            "13Μια φορά γεννηθήκαμε άνθρωποι, δυο φορές όμως δεν είναι δυνατό να γίνουμε",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20Για όλα τα πράγματα ο άνθρωπος είναι το μέτρο",
            "21[Ο άνθρωπος είναι] αυτός που αναλογίζεται και κρίνει όσα έχει δει.",
            "22ο άνθρωπος είναι τ’ όνειρο μιας σκιάς.",
            "23Eίναι αδύνατο να ξέρει την ιατρική, αυτός που δεν ξέρει ακριβώς τι είναι ο άνθρωπος",
            "24Γυμνοί ήρθαμε όλοι [σ’ αυτή τη ζωή], γυμνοί και θα φύγουμε",
            "25Αφού γεννήθηκες θνητός άνθρωπε, μην έχεις μεγάλες ιδέες",
            "26Κανένα κακό χωρίς κάποιο καλό",
            "27Το κακό είναι κακό. κι αν φαίνεται κι αν δεν φαίνεται",
            "28Πού παρέβην; τι έκανα; τι από αυτά που έπρεπε να κάνω δεν έγινε;",
            "29Οι ανόητοι ζουν χωρίς να είναι ευχαριστημένοι που ζουν.",
            "30Τη ζωή [σου], μιας και είναι σύντομη, μην την κάνεις [να φαίνεται] μακριά με κακά πράγματα",
            "31Ο κόσμος είναι μια [συνεχής] αλλαγή, η ζωή είναι γέννημα της φαντασίας.",
            "32Οι άνθρωποι για να τα βγάλουν πέρα στη ζωή τους, μηχανεύονται πολλά και διάφορα",
            "33Η αξία της ζωής μετριέται με την ωραιότητά της και όχι με το μήκος της",
            "34Η ζωή είναι σύντομη",
            "35Κανένας άνθρωπος δεν είναι τυχερός στο τέλος",
            "36Ο,τι πεθαίνει δεν πέφτει έξω από τον κόσμο [δεν χάνεται]",
            "37Ο θάνατος δεν είναι τίποτε άλλο, παρά ο διαχωρισμός δύο πραγμάτων, του ενός απ' το άλλο, δηλαδή της ψυχής από το σώμα.",
            "38Ο ύπνος και ο θάνατος είναι δίδυμα αδέλφια",
            "39Η ένωση της ψυχής και του σώματος [η γέννηση] δεν είναι με κανένα τρόπο καλύτερη από το χωρισμό τους [το θάνατο]",
            "40Λόγια πολλά λες, άνθρωπε, σε λίγο θα πεθάνεις. Σώπα, κι ενόσω ακόμα ζείς, τον θάνατο μελέτα",
            "41Μήπως ενώ έχουμε πεθάνει ζούμε μόνο κατά φαντασίαν," +
                    "εμείς οι Έλληνες, που έχομε περιπέσει σε συμφορά" +
                    "νομίζοντας ότι η ζωή είναι όνειρο;" +
                    "ή ζούμε εμείς, και έχει αποθάνει η ζωή;",
            "42Είναι γραφτό σε όλους να πεθάνουν",
            "43Πολλοί έλαβαν μέρος εις τα [Ελευσίνια]μυστήρια αλλά λίγοι είναι οι εκλεκτοί",
            "44Σε όλα υπάρχει εκ φύσεως κάτι το θείο",
            "45Σχετικά με τους θεούς, δεν ξέρω ούτε πώς είναι ούτε πώς δεν είναι.",
            "46Ο Θεός δεν είναι ποτέ καθόλου άδικος",
            "47Οι θεοί υπάρχουν σίγουρα, επειδή η γνώση που έχουμε γι’ αυτούς είναι εναργής",
            "48Θα ‘ρθει η μέρα που…",
            "49Οι καιροί [οι ευκαιρίες] δεν περιμένουν",
            "50Ο χρόνος αποκαλύπτει τα πάντα και τα φέρνει στο φως",
            "51Από το ποτήρι μέχρι τα χείλη πολλά γίνονται",
            "52Τα περισσότερα από αυτά που θα γίνουν στο μέλλον είναι ίδια μ’ αυτά που έχουν γίνει",
            "53Και εμείς θα γίνουμε πολύ καλύτεροι [από εσάς]",
            "54Να θυμάσαι όταν είσαι νέος ότι και συ θα γίνεις γέρος",
            "55Του αετού τα γηρατειά ισοδυναμούν με του κορυδαλλού τα νιάτα.",
            "56Ήμαστε κι εμείς κάποτε ρωμαλέοι νέοι."

    };

    final private String[] sayingEng = {
            "1Two legged animal with no wings.",
            "2We should not begin to examine facts from the causes, but the causes from the facts",
            "3What has 4 legs, then 2 and then 3?",
            "4From the human nature, what they want to do, that is what they do.",
            "5A man's enemy, is himself.",
            "6All humans, from their nature, have a flair for knowledge.",
            "7Long live humans!",
            "8Always remember that you are human",
            "9How wonderful humans are, when they are humans",
            "10A human is the dream of a shadow",
            "11",
            "12",
            "13We were born once as men, two times however we cannot be born",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20For everything, the human is the benchmark",
            "21[The human is] he who considers and criticizes what he sees",
            "22A human is the dream of a shadow",
            "23It is impossible to know medicine for one who does not understand what is a human",
            "24We all came naked [into this life], we will all leave naked",
            "25Since you were born a mortal, human, don't have great thoughts",
            "26No evil comes without some good",
            "27Evil is evil. Whether it is visible or not",
            "28What happened? What did I not do of the things I should have done?",
            "29Fools live like they are not happy to be alive",
            "30[Your] life since it is short, do not make it [feel] longer with bad things",
            "31The world is a [constant] change, life is born of imagination",
            "32Humans, to make do in life, come up with a great many things",
            "33The value of life is measured in its beauty, not its length",
            "34Life is short!",
            "35No man is lucky in the end",
            "36What dies does not leave this world.",
            "37Death is nothing more than the splitting of two things, the body and the soul",
            "38Sleep and death are twin siblings",
            "39The union of the body and the soul [birth] is no better than their separation [death]",
            "40You speak too much, human, soon you will die. Be silent, and while you leave, think of death",
            "41Perhaps while we have died, we live only in imagination," +
                    "us greeks, who have fallen to despair," +
                    "thinking that life is a dream?" +
                    "or do we live and life is dead?",
            "42Every man is fated to die",
            "43Many have taken part in the [Eleusinian] mysteries, but few were chosen",
            "44In everything, there is something divine",
            "45About the Gods, I know not how they are, neither how they are not",
            "46God is never unjust",
            "47Gods certainly exist because our knowledge about them is clear",
            "48There will come a day...",
            "49Times [opportunities] wait not",
            "50Time reveals everything and exposes them to the light",
            "51Many things can happen between the glass and the mouth",
            "52Most of the things that will happen in the future, are things that have already been done",
            "53And we will become much better [than you]",
            "54Remember while you are young that, you too, will become old",
            "55The eagle's old age is the same as the lark's young age",
            "56We too, were once strong young men"



    };

    final private String[] philosopherGr = {
            "1Ο ορισμός του ανθρώπου κατά τον Πλάτωνα",
            "2Πλάτων",
            "3Το αίνιγμα της Σφίγγας",
            "4Ιούλιος Καίσαρ",
            "5Ανάχαρσις",
            "6Διογένης",
            "7Φίλιππος Β’",
            "8Μένανδρος",
            "9Πίνδαρος",
            "10Σοφοκλής",
            "11Ιπποκράτης",
            "12Επίκουρος",
            "13Μένανδρος",
            "14Σωκράτης",
            "15Πλάτων",
            "16Μάρκος Αυρήλιος",
            "17Θαλής ο Μιλήσιος",
            "18Ηράκλειτος",
            "19Παλλαδάς ο Αλεξανδρεύς",
            "20Ηράκλειτος",
            "21Πλάτων",
            "22Πλάτων",
            "23Πίνδαρος",
            "24Ιπποκράτης",
            "25Αίσωπος",
            "26Μένανδρος",
            "27Αρχαίοελληνική παροιμία",
            "28Αντισθένης",
            "29Ερώτημα των Πυθαγορείων",
            "30Επίκουρος",
            "31Δημόκριτος",
            "32Θαλής ο Μιλήσιος",
            "33Δημόκριτος",
            "34Ιπποκράτης",
            "35Πλούταρχος",
            "36Ευριπίδης",
            "37Ευριπίδης",
            "38Μάρκος Αυρήλιος",
            "39Πλάτων",
            "40Όμηρος",
            "41Πλάτων",
            "42Παλλαδάς ο Αλεξανδρεύς",
            "43Παλλαδάς ο Αλεξανδρεύς",
            "44Πυθαγόρας",
            "45Πλάτων",
            "46Αριστοτέλης",
            "47Πρωταγόρας",
            "48Πλάτων",
            "49Επίκουρος",
            "50Αρχίλοχος",
            "51Όμηρος",
            "52Θουκυδίδης",
            "53Σοφοκλής",
            "54Ειπώθηκε από δούλο του αργοναύτη Ανταίου",
            "55Ευριπίδης",
            "56Τραγούδι από το χορό των νέων στις γιορτές της αρχαίας Σπάρτης.",
            "57Μένανδρος",
            "58Αρχαιοελληνική παροιμία",
            "59Τραγούδι από το χορό των γερόντων στις γιορτές της αρχ. Σπάρτης"
    };

    final private String[] getPhilosopherEng = {
            "1Plato's definition of the human being",
            "2Plato",
            "3Sphinx's riddle",
            "4Julius Caesar",
            "5Anacharsis",
            "6Diogenes",
            "7Philip II of Macedon",
            "8Menander",
            "9Pindar",
            "10Sophocles",
            "11Hippocrates",
            "12Epicurus",
            "13Menander",
            "14Socrates",
            "15Plato",
            "16Marcus Aurelius",
            "17Thales of Miletus",
            "18Heraclitus",
            "19Paladas of Alexandria",
            "20Heraclitus",
            "21Plato",
            "22Plato",
            "23Pindar",
            "24Hippocrates",
            "25Aesop",
            "26Menander",
            "27Ancient greek proverb",
            "28Antisthenes",
            "29Pythagorians' question",
            "30Epicurus",
            "31Democritus",
            "32Thales of Miletus",
            "33Democritus",
            "34Hippocrates",
            "35Plutarch",
            "36Euripides",
            "37Euripides",
            "38Marcus Aurelius",
            "39Plato",
            "40Homer",
            "41Plato",
            "42Paladas of Alexandria",
            "43Paladas of Alexandria",
            "44Pythagoras",
            "45Plato",
            "46Aristotle",
            "47Protagoras",
            "48Plato",
            "49Epicurus",
            "50Archilochus",
            "51Homer",
            "52Thucydides",
            "53Sophocles",
            "54Said by a slave of Antaeus",
            "55Euripides",
            "56Song from the young men's dance of ancient Sparta",
            "57Menander",
            "58Ancient greek proverb",
            "59Song from the young men's dance of ancient Sparta"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Length", "is " + sayingAnc.length);

    }


    public String getQuote(String type) {
        String tmp;
        if (type.equals("anc")) {
            tmp = sayingAnc[position];
        } else if (type.equals("gr")){
            tmp = sayingGr[position];
        } else if (type.equals("eng")){
            tmp = sayingEng[position];
        } else {
            return null;
        }
        return tmp;
    }

    public String getPhilosopher(String type) {
        String tmp;
        if (type.equals("anc")) {
            tmp = philosopherGr[position];
        } else {
            return null;
        }
        return tmp;
    }

    public void showQuote(View view){
        position = (int) (Math.random() * sayingAnc.length);
        String anc, gr, phil;
        Intent intent = new Intent(this,tellerActivity.class);
        anc = getQuote("anc");
        Log.d ("POSITION", "" + position);
        gr = getQuote("gr");
        Log.d ("POSITION", "" + position);
        //eng = getQuote("eng");
        phil = getPhilosopher("anc");
        Log.d ("POSITION", "" + position);

        intent.putExtra("anc", anc);
        intent.putExtra("gr", gr);
        intent.putExtra("phil", phil);
        startActivity(intent);
    }
}
