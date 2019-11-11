package se.su.dsv.prop.seminar1;

import java.io.IOException;

class Parser {
    Tokenizer tokenizer = null;

    void open(String fileName) throws IOException, TokenizerException {
        tokenizer = new Tokenizer();
        tokenizer.open(fileName);
        tokenizer.moveNext();
    }

    public INode parse() throws IOException, TokenizerException, ParserException {
        if (tokenizer == null)
            throw new IOException("No open file.");

        return new TextNode(tokenizer);
    }

    public void close() throws IOException {
        if (tokenizer != null)
            tokenizer.close();
    }

    private class TextNode implements INode {
        INode s;
        TextNode tx;

        public TextNode(Tokenizer t) {
            s = new SentenceNode(t);
            if (t.current().token() != Token.EOF) {
                tx = new TextNode(t);
            }
        }
    }

    private class SentenceNode implements INode {
        INode n;
        INode v;

        public SentenceNode(Tokenizer t) {
            n = new NounphraseNode(t);
            v = new VerbphraseNode(t);

            // TODO: check if the sentence ends with full stop

        }
    }

    private class NounphraseNode implements INode {
        INode d;
        INode n;

        public NounphraseNode(Tokenizer t) {
            d = new DeterminerNode(t);
            n = new NounNode(t);
        }
    }

    private class VerbphraseNode implements INode {
        INode v;
        NounphraseNode n;

        public VerbphraseNode(Tokenizer t) {
            v = new VerbNode(t);
            n = new NounphraseNode(t);
        }
    }

    private class DeterminerNode implements INode {
        Lexeme lexeme;

        public DeterminerNode(Tokenizer t) {
            try {
                lexeme = t.current();

                // TODO: check if this it a determiner otherwise error

                t.moveNext();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class NounNode implements INode {

        Lexeme lexeme;

        public NounNode(Tokenizer t) {
            try {
                lexeme = t.current();

                // TODO: check if this it a NOUN otherwise error

                t.moveNext();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class VerbNode implements INode {
        Lexeme lexeme;

        public VerbNode(Tokenizer t) {
            try {
                lexeme = t.current();

                // TODO: check if this it a VERB otherwise error

                t.moveNext();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: implement anonymous inner classes parsing the individual nodes
	//       in our parse tree

}
