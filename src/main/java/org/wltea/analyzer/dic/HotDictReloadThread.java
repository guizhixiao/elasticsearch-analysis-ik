package org.wltea.analyzer.dic;

import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.logging.ESLoggerFactory;

public class HotDictReloadThread implements Runnable {

    private static final Logger logger = ESLoggerFactory.getLogger(HotDictReloadThread.class.getName());

    @Override
    public void run() {
        while(true) {
            try {
                Dictionary.getSingleton().reLoadMainDict();
                Thread.sleep(Dictionary.INTERVAL);
                logger.info("[==========]reload hot dict from mysql......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
