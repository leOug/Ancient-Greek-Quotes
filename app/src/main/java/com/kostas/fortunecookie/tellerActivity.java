package com.kostas.fortunecookie;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;


public class tellerActivity extends AppCompatActivity {

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
            "1Πολλά τα δεινά κουδέν ανθρώπου δεινότερον πέλει.",
            "2Ουκ ένι ιατρικήν είδέναι, όστις μη οίδεν ό τι εστίν άνθρωπος.",
            "3Άπαξ άνθρωποι γεγόναμεν, δις δε ουκ έστι γενέσθαι.",
            "4Θνητός γεγονώς άνθρωπε, μη φρόνει μέγα.",
            "5Πρώτον μεν γαρ τρία ην τα γένη τα των ανθρώπων, ουχ ώσπερ νυν δύο.",
            "6Άνθρωπος τελειωθείς βέλτιστον των ζώων, χωρισθέν δε νόμου και δίκης, χείριστον πάντων.",
            "7Του ανθρωπίνου βίου ο μεν χρόνος στιγμή, η δε ουσία ρέουσα, η δε αίσθησις αμυδρά, η δε " +
                    "όλου του σώματος σύγκρισις εύσηπτος, η δε ψυχή ρόμβος, η δε τύχη δυστέκμαρτον, η δε φήμη άκριτον.",
            "8Κάλλιστον κόσμος, ποίημα γαρ θεού.",
            "9Κόσμον τονδε, τον αυτόν απάντων, ούτε τις θεών ούτε ανθρώπων εποίησεν, αλλ' ην αεί και έστιν και έστε πύρ αείζωον.",
            "20Σκηνή πας ο κόσμος εστί και παίγνιον· ή μάθε παίζειν ή φέρε τας οδύνας.",
            "1Τοις εγρηγορόσιν ένα και κοινόν κόσμον είναι, των δε κοιμωμένων έκαστον εις ίδιον αποστρέφεσθαι.",
            "2Πάντων χρημάτων μέτρον άνθρωπος.",
            "3Ο αναθρών ά όπωπε.",
            "4Σκιάς όναρ άνθρωπος.",
            "5Ουκ ένι ιατρικήν είδέναι, όστις μη οίδεν ό τι εστίν άνθρωπος.",
            "6Γυμνοί ήλθομεν οι πάντες, γυμνοί και απελευσόμεθα.",
            "7Θνητός γεγονώς άνθρωπε, μη φρόνει μέγα.",
            "8Ουδέν κακόν αμιγές καλού.",
            "9Αισχρόν το γ’ αισχρόν, καν δοκή καν μη δοκή.",
            "30Πη παρέβην; Τι δ’ έρεξα;Τι δε μοι δέον ουκ ετελέσθη;",
            "1Ανοήμονες βιούσι ού τερπόμενοι βιούν.",
            "2Τον βίον μη, τω χρόνω βραχύν όντα, πράγμασιν κακοίς μακρόν ποιείν.",
            "3Ο κόσμος αλλοίωσις, ο βίος υπόληψις.",
            "4Άνθρωποι βίου δεόμενοι, πολλά και παντοία τεχνέονται.",
            "5Μέτρον βίου το καλόν ου το του χρόνου μήκος.",
            "6Βραχύς αιών.",
            "7Θνητών όλβιος εις το τέλος ουδείς.",
            "8Έξω του κόσμου το αποθανόν ου πίπτει.",
            "9Ο θάνατος τυγχάνει ων, ως εμοί δοκεί, ουδέν άλλο ή δυοίν πραγμάτοιν διάλυσις, της ψυχής και του σώματος απ' αλλήλου.",
            "40Ύπνω και θανάτω διδυμάοσιν.",
            "1Κοινωνία γαρ ψυχή και σώματι διαλύσεως ουκ έστιν η κρείττον.",
            "2Πολλά λαλείς, άνθρωπε, χαμαί δε τίθη μετά μικρόν. Σίγα, και μελέτα ζών έτι τον θάνατον.",
            "3Άρα μη θανόντες τώ δοκείν ζώμεν μόνον," +
                    "Έλληνες άνδρες, συμφορά πεπτωκότες" +
                    "όνειρον εικάζοντες είναι τόν βίον;" +
                    "ή ζώμεν ημείς, τού βίου τεθνηκότος;",
            "4Θανέειν πέπρωται άπασι.",
            "5Εισί γάρ δή οι περί τάς τελετάς ναρθηκοφόροι μέν πολλοί, βάκχοι δε τε παύροι.",
            "6Πάντα γαρ φύσει έχει τι θείον.",
            "7Περί μεν θεών ουκ έχω ειδέναι, ούθ’ ως εισίν ουθ’ ως ουκ εισίν.",
            "8Θεός ουδαμή ουδαμώς άδικος.",
            "9Θεοί μεν γαρ εισίν. Εναργής γαρ αυτών εστιν η γνώσις.",
            "50Τοις θεοίς τίθει τα πάντα.",
            "1Έσσετ’ ήμαρ.",
            "2Οι καιροί ου μενετοί.",
            "3Πάντα εκκαλύπτων ο χρόνος εις το φως άγει.",
            "4Από κύλικος μέχρι χειλέων πολλά πέλει.",
            "5Όμοια γάρ ως επί το πολύ τα μέλλοντα τοις γεγονόσι.",
            "6Άμες γ’ εσόμεθα πολλώ κάρρονες.",
            "7Μέμνησο νέος ων, ως γέρων έση ποτέ.",
            "8Αετού γήρας κορύδου νεότης.",
            "9Αμές ποκ’ ήμες άλκιμοι νεανίαι."

    };

    final private String[] sayingGr = {
            "Ζώο δίποδο χωρίς φτερά",
            "Δεν πρέπει να ερευνούμε τα γεγονότα ξεκινώντας από τις αιτίες, αλλά τις αιτίες ξεκινώντας από τα γεγονότα",
            "Τι έχει 4 πόδια, μετά 2 πόδια και μετά 3;",
            "Από τη φύση του ο άνθρωπος, αυτό που θέλει, αυτό νομίζει",
            "Ο εχθρός του ανθρώπου είναι ο ίδιος εαυτός του",
            "Όλοι οι άνθρωποι έχουν από τη φύση τους έφεση για γνώση.",
            "Ζήτω ο άνθρωπος!",
            "Να θυμάσαι ότι είσαι άνθρωπος.",
            "Πόσο ωραίο πράγμα είναι ο άνθρωπος όταν είναι άνθρωπος ",
            "Το όνειρο της σκιάς είναι ο άνθρωπος",
            "Πολλά είναι τα φοβερά, μα τίποτα δεν υπάρχει πιο φοβερό απ' τον άνθρωπο.",
            "Είναι αδύνατον να ξέρει την ιατρική, αυτός που δεν ξέρει ακριβώς τι είναι ο άνθρωπος",
            "Μια φορά γεννηθήκαμε άνθρωποι, δυο φορές όμως δεν είναι δυνατό να γίνουμε",
            "Αφού γεννήθηκες θνητός άνθρωπε, μην έχεις μεγάλες ιδέες",
            "Στην αρχή τα γένη των ανθρώπων ήταν τρία, όχι δύο όπως τώρα.",
            "O άνθρωπος, όταν τελειωθεί, γίνεται άριστο πλάσμα, " +
                  "αν όμως απομακρυνθεί από τον νόμο και τη δικαιοσύνη, " +
                  "γίνεται το χειρότερο απ' όλα",
            "Της ανθρώπινης ζωής η διάρκεια όσο μια στιγμή, η ουσία της ρευστή, " +
                   "η αίσθησή της θολή, το σώμα -από τη σύστασή του- έτοιμο να σαπίσει, " +
                   "και η ψυχή ένας στρόβιλος, η τύχη άδηλη, η δόξα αβέβαιη.",
            "Το ωραιότερο πράγμα είναι ο κόσμος. Γιατί είναι έργο του Θεού",
            "Αυτόν εδώ τον κόσμο, τον ίδιο για όλους, ούτε κανείς θεός ούτε άνθρωπος τον έπλασε, " +
                  "αλλ' ήταν από πάντα και είναι και θα είναι αιώνια ζωντανή φωτιά",
            "Θέατρο είναι όλη η ζωή μα και παιχνίδι. Ή μάθε να παίζεις κάνοντας στην άκρη " +
                   "τη σοβαρότητα, ή υπέμεινε τα βάσανα.",
            "Για τους  ξύπνιους υπάρχει ένας και ο ίδιος κόσμος, ενώ οι κοιμισμένοι στρέφονται ο " +
                   "καθένας σε ένα δικό του, υποκειμενικό κόσμο",
            "Για όλα τα πράγματα ο άνθρωπος είναι το μέτρο",
            "[Ο άνθρωπος είναι] αυτός που αναλογίζεται και κρίνει όσα έχει δει.",
            "ο άνθρωπος είναι τ’ όνειρο μιας σκιάς.",
            "ίναι αδύνατο να ξέρει την ιατρική, αυτός που δεν ξέρει ακριβώς τι είναι ο άνθρωπος",
            "Γυμνοί ήρθαμε όλοι [σ’ αυτή τη ζωή], γυμνοί και θα φύγουμε",
            "Αφού γεννήθηκες θνητός άνθρωπε, μην έχεις μεγάλες ιδέες",
            "Κανένα κακό χωρίς κάποιο καλό",
            "Το κακό είναι κακό. κι αν φαίνεται κι αν δεν φαίνεται",
            "Πού παρέβην; Τι έκανα; Τι από αυτά που έπρεπε να κάνω δεν έγινε;",
            "Οι ανόητοι ζουν χωρίς να είναι ευχαριστημένοι που ζουν.",
            "Τη ζωή [σου], μιας και είναι σύντομη, μην την κάνεις [να φαίνεται] μακριά με κακά πράγματα",
            "Ο κόσμος είναι μια [συνεχής] αλλαγή, η ζωή είναι γέννημα της φαντασίας.",
            "Οι άνθρωποι για να τα βγάλουν πέρα στη ζωή τους, μηχανεύονται πολλά και διάφορα",
            "Η αξία της ζωής μετριέται με την ωραιότητά της και όχι με το μήκος της",
            "Η ζωή είναι σύντομη",
            "Κανένας άνθρωπος δεν είναι τυχερός στο τέλος",
            "Ο,τι πεθαίνει δεν πέφτει έξω από τον κόσμο [δεν χάνεται]",
            "Ο θάνατος δεν είναι τίποτε άλλο, παρά ο διαχωρισμός δύο πραγμάτων, του ενός απ' το άλλο, δηλαδή της ψυχής από το σώμα.",
            "Ο ύπνος και ο θάνατος είναι δίδυμα αδέλφια",
            "Η ένωση της ψυχής και του σώματος [η γέννηση] δεν είναι με κανένα τρόπο καλύτερη από το χωρισμό τους [το θάνατο]",
            "Λόγια πολλά λες, άνθρωπε, σε λίγο θα πεθάνεις. Σώπα, κι ενόσω ακόμα ζείς, τον θάνατο μελέτα",
            "Μήπως ενώ έχουμε πεθάνει ζούμε μόνο κατά φαντασίαν," +
                   "εμείς οι Έλληνες, που έχομε περιπέσει σε συμφορά" +
                   "νομίζοντας ότι η ζωή είναι όνειρο;" +
                   "ή ζούμε εμείς, και έχει αποθάνει η ζωή;",
            "Είναι γραφτό σε όλους να πεθάνουν",
            "Πολλοί έλαβαν μέρος εις τα [Ελευσίνια]μυστήρια αλλά λίγοι είναι οι εκλεκτοί",
            "Σε όλα υπάρχει εκ φύσεως κάτι το θείο",
            "Σχετικά με τους θεούς, δεν ξέρω ούτε πώς είναι ούτε πώς δεν είναι.",
            "Ο Θεός δεν είναι ποτέ καθόλου άδικος",
            "Οι θεοί υπάρχουν σίγουρα, επειδή η γνώση που έχουμε γι’ αυτούς είναι εναργής",
            "Άφηνέ τα όλα στη θέληση των θεών",
            "Θα ‘ρθει η μέρα που…",
            "Οι καιροί [οι ευκαιρίες] δεν περιμένουν",
            "Ο χρόνος αποκαλύπτει τα πάντα και τα φέρνει στο φως",
            "Από το ποτήρι μέχρι τα χείλη πολλά γίνονται",
            "Τα περισσότερα από αυτά που θα γίνουν στο μέλλον είναι ίδια μ’ αυτά που έχουν γίνει",
            "Και εμείς θα γίνουμε πολύ καλύτεροι [από εσάς]",
            "Να θυμάσαι όταν είσαι νέος ότι και συ θα γίνεις γέρος",
            "Του αετού τα γηρατειά ισοδυναμούν με του κορυδαλλού τα νιάτα.",
            "Ήμαστε κι εμείς κάποτε ρωμαλέοι νέοι."
    };

    final private String[] sayingEng = {
            "Two legged animal with no wings.",
            "We should not begin to examine facts from the causes, but the causes from the facts",
            "What has 4 legs, then 2 and then 3?",
            "From the human nature, what they want to do, that is what they do.",
            "A man's enemy, is himself.",
            "All humans, from their nature, have a flair for knowledge.",
            "Long live humans!",
            "Always remember that you are human",
            "How wonderful humans are, when they are humans",
            "A human is the dream of a shadow",
            "There are many terrible things, but nothing is more terrible than the human",
            "It is impossible for one to know medicine, if they do not know what exactly is a human",
            "We were born once as men, two times however we cannot be born",
            "Since you were born mortal, human, do not have great ideas",
            "In the beginning the genders of humans were three, not two like it is now",
            "Human, once completed, is an excellent creature. If, however, " +
                   "they stray from law and justice" +
                   ", they become the worst of all",
            "The length of a human's life is an instant, its meaning undefined" +
                  ", its feelings blurry, the body ready to rot, and the soul a tornado, " +
                  "fate is concealed, glory is uncertain",
            "The most beautiful thing is the world. Because it is a creation of God",
            "This world, the same for everyone, neither a God, nor a human made it, but " +
                   "has been and will always be a live fire.",
            "Life is a theater and a game as well. Either learn to play, pushing seriousness aside, or endure the harshness",
            "For those awake, there is only this world, while the ones sleeping live in their own, subjective world",
            "For everything, the human is the yardstick",
            "[The human is] he who considers and criticizes what he sees",
            "A human is the dream of a shadow",
            "It is impossible to know medicine for one who does not understand what is a human",
            "We all came naked [into this life], we will all leave naked",
            "Since you were born a mortal, human, don't have great thoughts",
            "No evil comes without some good",
            "Evil is evil. Whether it is visible or not",
            "What happened? What did I not do of the things I should have done?",
            "Fools live like they are not happy to be alive",
            "[Your] life since it is short, do not make it [feel] longer with bad things",
            "The world is a [constant] change, life is born of imagination",
            "Humans, to make do in life, come up with a great many things",
            "The value of life is measured in its beauty, not its length",
            "Life is short!",
            "No man is lucky in the end",
            "What dies does not leave this world.",
            "Death is nothing more than the splitting of two things, the body and the soul",
            "Sleep and death are twin siblings",
            "The union of the body and the soul [birth] is no better than their separation [death]",
            "You speak too much, human, soon you will die. Be silent, and while you leave, think of death",
            "Perhaps while we have died, we live only in imagination," +
                   "us greeks, who have fallen to despair," +
                   "thinking that life is a dream?" +
                   "or do we live and life is dead?",
            "Every man is fated to die",
            "Many have taken part in the [Eleusinian] mysteries, but few were chosen",
            "In everything, there is something divine",
            "About the Gods, I know not how they are, neither how they are not",
            "God is never unjust",
            "Gods certainly exist because our knowledge about them is clear",
            "Leave everyting to the Gods' will",
            "There will come a day...",
            "Times [opportunities] wait not",
            "Time reveals everything and exposes them to the light",
            "Many things can happen between the glass and the mouth",
            "Most of the things that will happen in the future, are things that have already been done",
            "And we will become much better [than you]",
            "Remember while you are young that, you too, will become old",
            "The eagle's old age is the same as the lark's young age",
            "We too, were once strong young men"

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
            "1Ιπποκράτης",
            "2Επίκουρος",
            "3Μένανδρος",
            "4Σωκράτης",
            "5Πλάτων",
            "6Μάρκος Αυρήλιος",
            "7Θαλής ο Μιλήσιος",
            "8Ηράκλειτος",
            "9Παλλαδάς ο Αλεξανδρεύς",
            "20Ηράκλειτος",
            "1Πλάτων",
            "2Πλάτων",
            "3Πίνδαρος",
            "4Ιπποκράτης",
            "5Αίσωπος",
            "6Μένανδρος",
            "7Αρχαίοελληνική παροιμία",
            "8Αντισθένης",
            "9Ερώτημα των Πυθαγορείων",
            "30Επίκουρος",
            "1Δημόκριτος",
            "2Θαλής ο Μιλήσιος",
            "3Δημόκριτος",
            "4Ιπποκράτης",
            "5Πλούταρχος",
            "6Ευριπίδης",
            "7Ευριπίδης",
            "8Μάρκος Αυρήλιος",
            "9Πλάτων",
            "40Όμηρος",
            "1Πλάτων",
            "2Παλλαδάς ο Αλεξανδρεύς",
            "3Παλλαδάς ο Αλεξανδρεύς",
            "4Πυθαγόρας",
            "5Πλάτων",
            "6Αριστοτέλης",
            "7Πρωταγόρας",
            "8Πλάτων",
            "9Επίκουρος",
            "50Αρχίλοχος",
            "1Όμηρος",
            "2Θουκυδίδης",
            "3Σοφοκλής",
            "4Ειπώθηκε από δούλο του αργοναύτη Ανταίου",
            "5Ευριπίδης",
            "6Τραγούδι από το χορό των νέων στις γιορτές της αρχαίας Σπάρτης.",
            "7Μένανδρος",
            "8Αρχαιοελληνική παροιμία",
            "9Τραγούδι από το χορό των γερόντων στις γιορτές της αρχ. Σπάρτης"
    };

    final private String[] philosopherEng = {
            "Plato's definition of the human being",
            "Plato",
            "Sphinx's riddle",
            "Julius Caesar",
            "Anacharsis",
            "Diogenes",
            "Philip II of Macedon",
            "Menander",
            "Pindar",
            "Sophocles",
            "Hippocrates",
            "Epicurus",
            "Menander",
            "Socrates",
            "Plato",
            "Marcus Aurelius",
            "Thales of Miletus",
            "Heraclitus",
            "Paladas of Alexandria",
            "Heraclitus",
            "Plato",
            "Plato",
            "Pindar",
            "Hippocrates",
            "Aesop",
            "Menander",
            "Ancient greek proverb",
            "Antisthenes",
            "Pythagorians' question",
            "Epicurus",
            "Democritus",
            "Thales of Miletus",
            "Democritus",
            "Hippocrates",
            "Plutarch",
            "Euripides",
            "Euripides",
            "Marcus Aurelius",
            "Plato",
            "Homer",
            "Plato",
            "Paladas of Alexandria",
            "Paladas of Alexandria",
            "Pythagoras",
            "Plato",
            "Aristotle",
            "Protagoras",
            "Plato",
            "Epicurus",
            "Archilochus",
            "Homer",
            "Thucydides",
            "Sophocles",
            "Said by a slave of Antaeus",
            "Euripides",
            "Song from the young men's dance of ancient Sparta",
            "Menander",
            "Ancient greek proverb",
            "Song from the young men's dance of ancient Sparta"
    };


    static public String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    TextView anc_quote;
    TextView quote;
    TextView philosopher;
    private int position;
    Switch sw;
    String anc, gr, eng, philGr, philEng;
    Animation ltor, rtol, ltor_phil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teller);

        anc_quote = (TextView) findViewById(R.id.anc_quote);
        quote = (TextView) findViewById(R.id.quote);
        philosopher = (TextView) findViewById(R.id.phil);

        sw = (Switch) findViewById(R.id.language);
        position = (int) (Math.random() * sayingAnc.length);
        sw.setChecked(true);
        ltor = AnimationUtils.loadAnimation(this, R.anim.ltor);
        rtol = AnimationUtils.loadAnimation(this, R.anim.rtol);
        rtol.setStartOffset(1000);
        ltor_phil = AnimationUtils.loadAnimation(this, R.anim.ltor_phil);
        ltor_phil.setStartOffset(1000);
        anc = getQuote("anc");
        anc_quote.setText(anc);
        eng = getQuote("eng");
        philEng = getQuote("philEng");
        quote.setText(eng);
        philosopher.setText("~" + philEng);
        anc_quote.startAnimation(ltor);
        quote.startAnimation(rtol);
        philosopher.startAnimation(ltor_phil);
        increaseTimes();
        saveDate();


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b) {
                    gr = getQuote("gr");
                    philGr = getQuote("philGr");

                    quote.setText(gr);
                    rtol.setStartOffset(0);
                    ltor_phil.setStartOffset(0);
                    quote.startAnimation(rtol);
                    philosopher.setText("~" + philGr);
                    philosopher.startAnimation(ltor_phil);
                } else {
                    quote.setText(eng);
                    rtol.setStartOffset(0);
                    ltor_phil.setStartOffset(0);
                    quote.startAnimation(rtol);
                    philosopher.setText("~" + philEng);
                    philosopher.startAnimation(ltor_phil);
                }

            }
        });


    }

    public void returnToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public String getQuote(String type) {
        String tmp;
        if (type.equals("anc")) {
            tmp = sayingAnc[position];
        } else if (type.equals("gr")) {
            tmp = sayingGr[position];
        } else if (type.equals("eng")) {
            tmp = sayingEng[position];
        } else if (type.equals("philGr")) {
            tmp = philosopherGr[position];
        } else if (type.equals("philEng")) {
            tmp = philosopherEng[position];
        } else {
            return null;
        }
        return tmp;
    }

    public void saveDate() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        writeToFile(day, month, year);

    }

    public void increaseTimes () {
        File file = new File(path, "times.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "There is has been an error (possibly not enough space)", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        if (file.length() != 0) {
            int tmp = getTimesSoFar();
            saveTimes(file, tmp + 1);
        } else {
            saveTimes(file, 1);
        }

    }

    public void saveTimes(File file, int number) {
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                    if (fos != null) {
                        String numberToSave = number + "";
                        fos.write(numberToSave.getBytes());
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    public void writeToFile(int day, int month, int year) {
        File file = new File(path, "log.txt");
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] save = new String[3];
        save[0] = day + "";
        save[1] = month + "";
        save[2] = year + "";
        Save(file, save);
    }

    public int getTimesSoFar() {
        File file = new File(path, "times.txt");
        String tmp;
        boolean isEmpty = true;
        if (file.exists()) {
            if (file.length() == 0) {
                return 0;
            } else {
                tmp = LoadTimes(file);
                if (tmp != null && !tmp.equals("")) {
                    try {
                        return Integer.parseInt(tmp);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        } else{
            return 0;
        }
    }

    public String LoadTimes(File file) {
        Log.i ("DEBUG", "In teller loadTimes");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        try {
            fis.getChannel().position(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String tmp = null;
        String line;
        int i = 0;
        try {
            if ((line = br.readLine()) != null) {
                tmp = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }


    public boolean exists() {
        File file = new File(path, "log.txt");
        return file.exists();
    }




    public void Save(File file, String[] data) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                for (int i = 0; i < data.length; i++) {
                    if (fos != null) {
                        fos.write(data[i].getBytes());
                    }
                    if (i < data.length - 1) {
                        if (fos != null) {
                            fos.write("\n".getBytes());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


}
