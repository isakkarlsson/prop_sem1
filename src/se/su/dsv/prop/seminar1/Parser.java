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
        // TODO: return the root node of our parse tree
		return null;
    }

    public void close() throws IOException {
        if (tokenizer != null)
            tokenizer.close();
    }

	// TODO: implement anonymous inner classes parsing the individual nodes
	//       in our parse tree

}
