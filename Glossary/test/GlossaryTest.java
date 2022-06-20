import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class GlossaryTest {

    @Test
    public void getMapTest_1() {
        // normal map
        String fileName = "get_map_test_1.txt";
        SimpleWriter wordDefinitionTest = new SimpleWriter1L(fileName);
        wordDefinitionTest.println("amazing");
        wordDefinitionTest.println("my lifestyle");
        wordDefinitionTest.println();
        wordDefinitionTest.println("horrible");
        wordDefinitionTest.println("not my lifestyle");
        wordDefinitionTest.println();
        wordDefinitionTest.println("mid");
        wordDefinitionTest.println("sometimes my lifestyle");
        wordDefinitionTest.println();
        Map<String, String> mapExpected = new Map1L<>();
        Map<String, String> map = new Map1L<>();
        mapExpected.add("amazing", "my lifestyle ");
        mapExpected.add("horrible", "not my lifestyle ");
        mapExpected.add("mid", "sometimes my lifestyle ");

        Glossary.getMap(fileName, map);
        assertEquals(mapExpected, map);

    }

    @Test
    public void getMapTest_2() {
        // empty file
        String fileName = "get_map_test_2.txt";
        SimpleWriter wordDefinitionTest = new SimpleWriter1L(fileName);
        Map<String, String> mapExpected = new Map1L<>();
        Map<String, String> map = new Map1L<>();

        Glossary.getMap(fileName, map);
        assertEquals(mapExpected, map);

    }

    @Test
    public void getMapTest_3() {
        // definition is more than one line
        String fileName = "get_map_test_3.txt";
        SimpleWriter wordDefinitionTest = new SimpleWriter1L(fileName);
        wordDefinitionTest.println("amazing");
        wordDefinitionTest.println("my lifestyle");
        wordDefinitionTest.println();
        wordDefinitionTest.println("horrible");
        wordDefinitionTest.println("not my lifestyle");
        wordDefinitionTest.println("but it is everyone else's");
        wordDefinitionTest.println();
        wordDefinitionTest.println("mid");
        wordDefinitionTest.println("sometimes my lifestyle");
        wordDefinitionTest.println();
        Map<String, String> mapExpected = new Map1L<>();
        Map<String, String> map = new Map1L<>();
        mapExpected.add("amazing", "my lifestyle ");
        mapExpected.add("horrible",
                "not my lifestyle but it is everyone else's ");
        mapExpected.add("mid", "sometimes my lifestyle ");

        Glossary.getMap(fileName, map);
        assertEquals(mapExpected, map);
    }

    @Test
    public void wordQueueTest_1() {
        // normal word queue
        String fileName = "word_queue_test_1.txt";
        SimpleWriter wordDefinitionTest = new SimpleWriter1L(fileName);
        wordDefinitionTest.println("amazing");
        wordDefinitionTest.println("my lifestyle");
        wordDefinitionTest.println();
        wordDefinitionTest.println("horrible");
        wordDefinitionTest.println("not my lifestyle");
        wordDefinitionTest.println();
        wordDefinitionTest.println("mid");
        wordDefinitionTest.println("sometimes my lifestyle");
        wordDefinitionTest.println();

        Map<String, String> mapExpected = new Map1L<>();
        mapExpected.add("amazing", "my lifestyle");
        mapExpected.add("horrible", "not my lifestyle");
        mapExpected.add("mid", "sometimes my lifestyle");
        Map<String, String> map = new Map1L<>();
        map.add("amazing", "my lifestyle");
        map.add("horrible", "not my lifestyle");
        map.add("mid", "sometimes my lifestyle");
        Queue<String> wordBank = new Queue1L<>();
        Queue<String> wordBankExpected = new Queue1L<>();
        wordBankExpected.enqueue("amazing");
        wordBankExpected.enqueue("horrible");
        wordBankExpected.enqueue("mid");

        Glossary.wordQueue(map, wordBank);
        assertEquals(wordBankExpected, wordBank);
        assertEquals(mapExpected, map);

    }

    @Test
    public void wordQueueTest_2() {
        // words not in order
        String fileName = "word_queue_test_2.txt";
        SimpleWriter wordDefinitionTest = new SimpleWriter1L(fileName);
        wordDefinitionTest.println("zebra");
        wordDefinitionTest.println("my lifestyle");
        wordDefinitionTest.println();
        wordDefinitionTest.println("horrible");
        wordDefinitionTest.println("not my lifestyle");
        wordDefinitionTest.println();
        wordDefinitionTest.println("mid");
        wordDefinitionTest.println("sometimes my lifestyle");
        wordDefinitionTest.println();

        Map<String, String> mapExpected = new Map1L<>();
        mapExpected.add("zebra", "my lifestyle");
        mapExpected.add("horrible", "not my lifestyle");
        mapExpected.add("mid", "sometimes my lifestyle");
        Map<String, String> map = new Map1L<>();
        map.add("zebra", "my lifestyle");
        map.add("horrible", "not my lifestyle");
        map.add("mid", "sometimes my lifestyle");
        Queue<String> wordBank = new Queue1L<>();
        Queue<String> wordBankExpected = new Queue1L<>();
        wordBankExpected.enqueue("horrible");
        wordBankExpected.enqueue("mid");
        wordBankExpected.enqueue("zebra");

        Glossary.wordQueue(map, wordBank);
        assertEquals(wordBankExpected, wordBank);
        assertEquals(mapExpected, map);

    }

    @Test
    public void wordQueueTest_3() {
        // empty word
        String fileName = "word_queue_test_3.txt";
        SimpleWriter wordDefinitionTest = new SimpleWriter1L(fileName);
        Map<String, String> mapExpected = new Map1L<>();
        Map<String, String> map = new Map1L<>();
        Queue<String> wordBank = new Queue1L<>();
        Queue<String> wordBankExpected = new Queue1L<>();

        Glossary.wordQueue(map, wordBank);
        assertEquals(wordBankExpected, wordBank);
        assertEquals(mapExpected, map);
    }

    @Test
    public void generateElementsTest_1() {
        // regular input
        String str = "hello";
        Set<Character> charSet = new Set1L<>();
        Set<Character> charSetExpected = new Set1L<>();
        charSetExpected.add('h');
        charSetExpected.add('e');
        charSetExpected.add('l');
        charSetExpected.add('o');

        Glossary.generateElements(str, charSet);
        assertEquals(charSetExpected, charSet);
    }

    @Test
    public void generateElementsTest_2() {
        // input with space
        String str = "hello ";
        Set<Character> charSet = new Set1L<>();
        Set<Character> charSetExpected = new Set1L<>();
        charSetExpected.add('h');
        charSetExpected.add('e');
        charSetExpected.add('l');
        charSetExpected.add('o');
        charSetExpected.add(' ');

        Glossary.generateElements(str, charSet);
        assertEquals(charSetExpected, charSet);
    }

    @Test
    public void generateElementsTest_3() {
        // input with comma
        String str = "hell,o";
        Set<Character> charSet = new Set1L<>();
        Set<Character> charSetExpected = new Set1L<>();
        charSetExpected.add('h');
        charSetExpected.add('e');
        charSetExpected.add('l');
        charSetExpected.add('o');
        charSetExpected.add(',');

        Glossary.generateElements(str, charSet);
        assertEquals(charSetExpected, charSet);
    }

    @Test
    public void nextWordOrSeparatorTest_1() {
        // input without separator

        int position = 0;
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        String text = "nickcheong ";
        String resultExpected = "nickcheong";
        String result = Glossary.nextWordOrSeparator(text, position,
                separators);
        assertEquals(resultExpected, result);

    }

    @Test
    public void nextWordOrSeparatorTest_2() {
        // normal input - printing the first word
        int position = 0;
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        String text = "nick cheong ";
        String resultExpected = "nick";
        String result = Glossary.nextWordOrSeparator(text, position,
                separators);
        assertEquals(resultExpected, result);

    }

    @Test
    // printing the separator
    public void nextWordOrSeparatorTest_3() {
        int position = 4;
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        String text = "nick cheong";
        String resultExpected = " ";
        String result = Glossary.nextWordOrSeparator(text, position,
                separators);

        assertEquals(resultExpected, result);

    }

    @Test
    // printing the second word
    public void nextWordOrSeparatorTest_4() {
        int position = 5;
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        String text = "nick cheong";
        String resultExpected = "cheong";
        String result = Glossary.nextWordOrSeparator(text, position,
                separators);

        assertEquals(resultExpected, result);

    }

    @Test
    public void generateHTMLTest_1() {
        // no links in definition
        Map<String, String> wordDefinition = new Map1L<>();
        wordDefinition.add("nick", "the coolest person");
        Map<String, String> wordDefinitionExpected = new Map1L<>();
        wordDefinitionExpected.add("nick", "the coolest person");
        Queue<String> wordBank = new Queue1L<>();
        wordBank.enqueue("nick");
        Queue<String> wordBankExpected = new Queue1L<>();
        wordBankExpected.enqueue("nick");
        SimpleWriter out = new SimpleWriter1L("generate_HTML_test_1.txt");
        SimpleWriter outFile = new SimpleWriter1L(
                "generate_HTML_subtest_1.txt");

        SimpleReader in = new SimpleReader1L("generate_HTML_test_1.txt");

        String outputFile = "test";
        String word = "nick";
        String wordExpected = "nick";
        String definition = "the coolest person";
        String definitionExpected = "the coolest person";

        Glossary.generateHTML(wordDefinitionExpected, word, definition, out,
                outputFile);
        assertEquals("<a href = nick.html>", in.nextLine());
        assertEquals("nick", in.nextLine());
        assertEquals("</a>", in.nextLine());
        SimpleReader inFile = new SimpleReader1L(
                outputFile + "/" + word + ".html");
        assertEquals("<head>", inFile.nextLine());
        assertEquals("<title>", inFile.nextLine());
        assertEquals(wordExpected, inFile.nextLine());
        assertEquals("</title>", inFile.nextLine());
        assertEquals("</head>", inFile.nextLine());
        assertEquals("<body>", inFile.nextLine());
        assertEquals("<h2>", inFile.nextLine());
        assertEquals("<b>", inFile.nextLine());
        assertEquals("<i>", inFile.nextLine());
        assertEquals("<font color = \"red\">" + wordExpected + "</font>",
                inFile.nextLine());
        assertEquals("</i>", inFile.nextLine());
        assertEquals("</b>", inFile.nextLine());
        assertEquals("</h2>", inFile.nextLine());
        assertEquals("<blockquote>", inFile.nextLine());
        assertEquals(definitionExpected, inFile.nextLine());
        assertEquals("</blockquote>", inFile.nextLine());
        assertEquals("<hr>", inFile.nextLine());
        assertEquals("<p>", inFile.nextLine());
        assertEquals("Return to", inFile.nextLine());
        assertEquals("<a href = index.html>", inFile.nextLine());
        assertEquals("index</a>.", inFile.nextLine());
        assertEquals("</p>", inFile.nextLine());
        assertEquals("</body>", inFile.nextLine());
        assertEquals("</html>", inFile.nextLine());
    }

    @Test
    public void generateHTMLTest_2() {
        // links in definition
        Map<String, String> wordDefinition = new Map1L<>();
        wordDefinition.add("nick", "the coolest");
        wordDefinition.add("coolest", "something awesome");
        Map<String, String> wordDefinitionExpected = new Map1L<>();
        wordDefinitionExpected.add("nick", "the coolest");
        wordDefinitionExpected.add("coolest", "something awesome");
        Queue<String> wordBank = new Queue1L<>();
        wordBank.enqueue("nick");
        Queue<String> wordBankExpected = new Queue1L<>();
        wordBankExpected.enqueue("nick");
        SimpleWriter out = new SimpleWriter1L("generate_HTML_test_2.txt");
        SimpleWriter outFile = new SimpleWriter1L(
                "generate_HTML_subtest_2.txt");

        SimpleReader in = new SimpleReader1L("generate_HTML_test_2.txt");

        String outputFile = "test";
        String word = "nick";
        String wordExpected = "nick";
        String definition = "the coolest";
        String definitionExpected = "the <a href = coolest.html>coolest</a>";

        Glossary.generateHTML(wordDefinitionExpected, word, definition, out,
                outputFile);
        assertEquals("<a href = nick.html>", in.nextLine());
        assertEquals("nick", in.nextLine());
        assertEquals("</a>", in.nextLine());
        SimpleReader inFile = new SimpleReader1L(
                outputFile + "/" + word + ".html");
        assertEquals("<head>", inFile.nextLine());
        assertEquals("<title>", inFile.nextLine());
        assertEquals(wordExpected, inFile.nextLine());
        assertEquals("</title>", inFile.nextLine());
        assertEquals("</head>", inFile.nextLine());
        assertEquals("<body>", inFile.nextLine());
        assertEquals("<h2>", inFile.nextLine());
        assertEquals("<b>", inFile.nextLine());
        assertEquals("<i>", inFile.nextLine());
        assertEquals("<font color = \"red\">" + wordExpected + "</font>",
                inFile.nextLine());
        assertEquals("</i>", inFile.nextLine());
        assertEquals("</b>", inFile.nextLine());
        assertEquals("</h2>", inFile.nextLine());
        assertEquals("<blockquote>", inFile.nextLine());
        assertEquals(definitionExpected, inFile.nextLine());
        assertEquals("</blockquote>", inFile.nextLine());
        assertEquals("<hr>", inFile.nextLine());
        assertEquals("<p>", inFile.nextLine());
        assertEquals("Return to", inFile.nextLine());
        assertEquals("<a href = index.html>", inFile.nextLine());
        assertEquals("index</a>.", inFile.nextLine());
        assertEquals("</p>", inFile.nextLine());
        assertEquals("</body>", inFile.nextLine());
        assertEquals("</html>", inFile.nextLine());
    }

    @Test
    public void generateHTMLTest_3() {
        // multiple links in definition
        Map<String, String> wordDefinition = new Map1L<>();
        wordDefinition.add("nick", "the coolest person");
        wordDefinition.add("coolest", "something awesome");
        wordDefinition.add("person", "a human");
        Map<String, String> wordDefinitionExpected = new Map1L<>();
        wordDefinitionExpected.add("nick", "the coolest");
        wordDefinitionExpected.add("coolest", "something awesome");
        wordDefinitionExpected.add("person", "a human");
        Queue<String> wordBank = new Queue1L<>();
        wordBank.enqueue("nick");
        Queue<String> wordBankExpected = new Queue1L<>();
        wordBankExpected.enqueue("nick");
        SimpleWriter out = new SimpleWriter1L("generate_HTML_test_2.txt");
        SimpleWriter outFile = new SimpleWriter1L(
                "generate_HTML_subtest_2.txt");

        SimpleReader in = new SimpleReader1L("generate_HTML_test_2.txt");

        String outputFile = "test";
        String word = "nick";
        String wordExpected = "nick";
        String definition = "the coolest person";
        String definitionExpected = "the <a href = coolest.html>coolest</a> <a href = person.html>person</a>";

        Glossary.generateHTML(wordDefinitionExpected, word, definition, out,
                outputFile);
        assertEquals("<a href = nick.html>", in.nextLine());
        assertEquals("nick", in.nextLine());
        assertEquals("</a>", in.nextLine());
        SimpleReader inFile = new SimpleReader1L(
                outputFile + "/" + word + ".html");
        assertEquals("<head>", inFile.nextLine());
        assertEquals("<title>", inFile.nextLine());
        assertEquals(wordExpected, inFile.nextLine());
        assertEquals("</title>", inFile.nextLine());
        assertEquals("</head>", inFile.nextLine());
        assertEquals("<body>", inFile.nextLine());
        assertEquals("<h2>", inFile.nextLine());
        assertEquals("<b>", inFile.nextLine());
        assertEquals("<i>", inFile.nextLine());
        assertEquals("<font color = \"red\">" + wordExpected + "</font>",
                inFile.nextLine());
        assertEquals("</i>", inFile.nextLine());
        assertEquals("</b>", inFile.nextLine());
        assertEquals("</h2>", inFile.nextLine());
        assertEquals("<blockquote>", inFile.nextLine());
        assertEquals(definitionExpected, inFile.nextLine());
        assertEquals("</blockquote>", inFile.nextLine());
        assertEquals("<hr>", inFile.nextLine());
        assertEquals("<p>", inFile.nextLine());
        assertEquals("Return to", inFile.nextLine());
        assertEquals("<a href = index.html>", inFile.nextLine());
        assertEquals("index</a>.", inFile.nextLine());
        assertEquals("</p>", inFile.nextLine());
        assertEquals("</body>", inFile.nextLine());
        assertEquals("</html>", inFile.nextLine());
    }

    @Test
    public void generateWordTest_1() {
        // test output file - test
        // normal input - no need to test html outputs because will be the same
        Map<String, String> wordDefinition = new Map1L<>();
        wordDefinition.add("nick", "the coolest");
        Map<String, String> wordDefinitionExpected = new Map1L<>();
        wordDefinitionExpected.add("nick", "the coolest");
        Queue<String> wordBank = new Queue1L<>();
        wordBank.enqueue("nick");
        Queue<String> wordBankExpected = new Queue1L<>();
        wordBankExpected.enqueue("nick");
        SimpleWriter out = new SimpleWriter1L("generate_word_test_1.txt");
        SimpleReader in = new SimpleReader1L("generate_word_test_1.txt");
        String outputFile = "test";
        Glossary.generateWord(wordBank, wordDefinition, out, outputFile);
        assertEquals(wordDefinitionExpected, wordDefinition);
        assertEquals(wordBankExpected, wordBank);
        assertEquals("<li>", in.nextLine());
        assertEquals("<a href = nick.html>", in.nextLine());
        assertEquals("nick", in.nextLine());
        assertEquals("</a>", in.nextLine());
        assertEquals("</li>", in.nextLine());

    }

    @Test
    public void generateWordTest_2() {
        // test output file - test2
        // normal input - no need to test html outputs because will be the same
        Map<String, String> wordDefinition = new Map1L<>();
        wordDefinition.add("nick", "the coolest");
        Map<String, String> wordDefinitionExpected = new Map1L<>();
        wordDefinitionExpected.add("nick", "the coolest");
        Queue<String> wordBank = new Queue1L<>();
        wordBank.enqueue("nick");
        Queue<String> wordBankExpected = new Queue1L<>();
        wordBankExpected.enqueue("nick");
        SimpleWriter out = new SimpleWriter1L("generate_word_test_1.txt");
        SimpleReader in = new SimpleReader1L("generate_word_test_1.txt");
        String outputFile = "test2";
        Glossary.generateWord(wordBank, wordDefinition, out, outputFile);
        assertEquals(wordDefinitionExpected, wordDefinition);
        assertEquals(wordBankExpected, wordBank);
        assertEquals("<li>", in.nextLine());
        assertEquals("<a href = nick.html>", in.nextLine());
        assertEquals("nick", in.nextLine());
        assertEquals("</a>", in.nextLine());
        assertEquals("</li>", in.nextLine());

    }

    @Test
    public void generateWordTest_4() {
        // testing different word
        // normal input - no need to test html outputs because will be the same
        Map<String, String> wordDefinition = new Map1L<>();
        wordDefinition.add("not nick", "the coolest");
        Map<String, String> wordDefinitionExpected = new Map1L<>();
        wordDefinitionExpected.add("not nick", "the coolest");
        Queue<String> wordBank = new Queue1L<>();
        wordBank.enqueue("not nick");
        Queue<String> wordBankExpected = new Queue1L<>();
        wordBankExpected.enqueue("not nick");
        SimpleWriter out = new SimpleWriter1L("generate_word_test_1.txt");
        SimpleReader in = new SimpleReader1L("generate_word_test_1.txt");
        String outputFile = "test";
        Glossary.generateWord(wordBank, wordDefinition, out, outputFile);
        assertEquals(wordDefinitionExpected, wordDefinition);
        assertEquals(wordBankExpected, wordBank);
        assertEquals("<li>", in.nextLine());
        assertEquals("<a href = not nick.html>", in.nextLine());
        assertEquals("not nick", in.nextLine());
        assertEquals("</a>", in.nextLine());
        assertEquals("</li>", in.nextLine());

    }

    @Test
    // match expected - 1 test since method will print out the same
    public void generateIndexTest_1() {
        SimpleWriter out = new SimpleWriter1L("test_3.txt");
        Glossary.generateIndex(out);
        SimpleReader in = new SimpleReader1L("test_3.txt");
        assertEquals("<html>", in.nextLine());
        assertEquals("<head>", in.nextLine());
        assertEquals("<title>", in.nextLine());
        assertEquals("Glossary", in.nextLine());
        assertEquals("</title>", in.nextLine());
        assertEquals("</head>", in.nextLine());
        assertEquals("<body>", in.nextLine());
        assertEquals("<h2>Glossary</h2>", in.nextLine());
        assertEquals("<hr>", in.nextLine());
        assertEquals("<h3>Index</h3>", in.nextLine());
        assertEquals("<ul>", in.nextLine());

    }

    @Test
    // match expected - 1 test since method will print out the same
    public void generateCloserTest_1() {
        SimpleWriter out = new SimpleWriter1L("test_4.txt");
        Glossary.generateCloser(out);
        SimpleReader in = new SimpleReader1L("test_4.txt");
        assertEquals("</ul>", in.nextLine());
        assertEquals("</body>", in.nextLine());
        assertEquals("</html>", in.nextLine());
    }

}
