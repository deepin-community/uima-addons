/**
 * 	Licensed to the Apache Software Foundation (ASF) under one
 * 	or more contributor license agreements.  See the NOTICE file
 * 	distributed with this work for additional information
 * 	regarding copyright ownership.  The ASF licenses this file
 * 	to you under the Apache License, Version 2.0 (the
 * 	"License"); you may not use this file except in compliance
 * 	with the License.  You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * 	Unless required by applicable law or agreed to in writing,
 * 	software distributed under the License is distributed on an
 * 	"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * 	KIND, either express or implied.  See the License for the
 * 	specific language governing permissions and limitations
 * 	under the License.
 */
package org.apache.uima.alchemy.digester.sentiment;

import org.apache.commons.digester.Digester;
import org.apache.uima.alchemy.digester.OutputDigester;
import org.apache.uima.alchemy.digester.domain.DocumentSentiment;
import org.apache.uima.alchemy.digester.domain.Results;
import org.apache.uima.alchemy.digester.domain.SentimentAnalysisResults;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * Digester for XML output of sentiment analysis service
 */
public class XMLSentimentAnalysisDigester implements OutputDigester {
  public Results parseAlchemyXML(InputStream responseStream) throws IOException, SAXException,
          URISyntaxException {
    Digester digester = new Digester();
    digester.setValidating(false);

    digester.addObjectCreate("results", SentimentAnalysisResults.class);
    digester.addBeanPropertySetter("results/status", "status");
    digester.addBeanPropertySetter("results/statusInfo", "statusInfo");
    digester.addBeanPropertySetter("results/url", "url");
    digester.addBeanPropertySetter("results/language", "language");
    digester.addObjectCreate("results/docSentiment", DocumentSentiment.class);
    digester.addBeanPropertySetter("results/docSentiment/type", "type");
    digester.addBeanPropertySetter("results/docSentiment/score", "score");
    digester.addSetNext("results/docSentiment", "setDocSentiment");

    return (Results) digester.parse(responseStream);
  }
}
