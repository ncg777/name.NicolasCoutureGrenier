package name.ncg777;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import name.ncg777.maths.applications.*;
import name.ncg777.music.applications.*;
import java.awt.GridLayout;
import java.io.File;
import java.net.URISyntaxException;

public class MainMenuGUI {
  public static void main(String[] args) {
    // Create the main frame
    JFrame mainFrame = new JFrame("Main Menu");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(800, 600); // Adjust size as needed

    // Create a panel to hold buttons
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(0, 1)); // Dynamic vertical layout

    addAppButton(panel, "BitCounter", BitCounter.class);
    addAppButton(panel, "LatticePath", LatticePath.class);
    addAppButton(panel, "MixedRadix", MixedRadix.class);
    addAppButton(panel, "ModularArithmeticSequencer", ModularArithmeticSequencer.class);
    addAppButton(panel, "NecklaceGenerator", NecklaceGenerator.class);
    addAppButton(panel, "Permutator", Permutator.class);
    addAppButton(panel, "PitchClassSet12GraphExplorer", PitchClassSet12GraphExplorer.class);
    addAppButton(panel, "PitchClassSet12Identifier", PitchClassSet12Identifier.class);
    addAppButton(panel, "PitchClassSet12Matrix", PitchClassSet12Matrix.class);
    addAppButton(panel, "PitchClassSet12Navigator", PitchClassSet12Navigator.class);
    addAppButton(panel, "PitchClassSet12PairIntersectionAndUnion", PitchClassSet12PairIntersectionAndUnion.class);
    addAppButton(panel, "PitchClassSet12Permutator", PitchClassSet12Permutator.class);
    addAppButton(panel, "PitchClassSet12Rotator", PitchClassSet12Rotator.class);
    addAppButton(panel, "PitchClassSet12SequenceMerger", PitchClassSet12SequenceMerger.class);
    addAppButton(panel, "PitchClassSet12SequenceVisualizer", PitchClassSet12SequenceVisualizer.class);
    addAppButton(panel, "PitchClassSet12Sorter", PitchClassSet12Sorter.class);
    addAppButton(panel, "PitchClassSet12Walker", PitchClassSet12Walker.class);
    addAppButton(panel, "PseudoBase", PseudoBase.class);
    addAppButton(panel, "R16Divider", R16Divider.class);
    addAppButton(panel, "RandomWalker1", RandomWalker1.class);
    addAppButton(panel, "Range", Range.class);
    addAppButton(panel, "RhythmDiluter", RhythmDiluter.class);
    addAppButton(panel, "RhythmicPulsations", RhythmicPulsations.class);
    addAppButton(panel, "RhythmicSeqGen", RhythmicSeqGen.class);
    addAppButton(panel, "ScaleModulo", ScaleModulo.class);
    addAppButton(panel, "SeqGenBySegments", SeqGenBySegments.class);
    addAppButton(panel, "SeqGenContourFollow", SeqGenContourFollow.class);
    addAppButton(panel, "SeqGenFS", SeqGenFS.class);
    addAppButton(panel, "SeqGenFixedSum", SeqGenFixedSum.class);
    addAppButton(panel, "SequenceCalc", SequenceCalc.class);
    addAppButton(panel, "SequenceConvolver", SequenceConvolver.class);
    addAppButton(panel, "SequenceConvolverAbsoluteTime", SequenceConvolverAbsoluteTime.class);
    addAppButton(panel, "SequenceMap", SequenceMap.class);
    addAppButton(panel, "SequenceMerger", SequenceMerger.class);
    addAppButton(panel, "SequencePermutate", SequencePermutate.class);
    addAppButton(panel, "SequenceScaleModuloPermutation", SequenceScaleModuloPermutation.class);
    addAppButton(panel, "SequenceWrapper", SequenceWrapper.class);
    addAppButton(panel, "SmoothArticulator", SmoothArticulator.class);
    addAppButton(panel, "Tri", Tri.class);
    addAppButton(panel, "WordPermutator", WordPermutator.class);
    addAppButton(panel, "WordSequencer", WordSequencer.class);
    addAppButton(panel, "XORCircularConvolver", XORCircularConvolver.class);
    addAppButton(panel, "XRSequenceGenerator", XRSequenceGenerator.class);
    addAppButton(panel, "k-ComplexExplorer", KComplexExplorer.class);
    addAppButton(panel, "x2mid", x2mid.class);
addAppButton(panel, "AddSequences", AddSequences.class);

    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

    // Add the scroll pane to the main frame
    mainFrame.add(scrollPane);

    // Set frame visibility
    mainFrame.setVisible(true);
  }

  private static void addAppButton(JPanel panel, String appName, Class<?> appClass) {
    JButton button = new JButton(appName);
    button.addActionListener(e -> {
      openApp(appClass);
    });
    panel.add(button);
  }

  private static void openApp(Class<?> appClass) {
    try {
      var appClassName = appClass.getCanonicalName();
      String currentJarPath = getCurrentJarPath();

      String classpath =
          currentJarPath + File.pathSeparator + System.getProperty("java.class.path");

      ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", classpath, appClassName);
      processBuilder.start();

    } catch (Exception ex) {
      System.err.println("Error opening application: " + ex.getMessage());
      ex.printStackTrace();
    }
  }

  private static String getCurrentJarPath() throws URISyntaxException {
    String jarPath = MainMenuGUI.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
    
    return jarPath;
  }
}