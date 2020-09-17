package com.lucky.ut.effective.h2;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author xiuyin.cui@luckincoffee.com
 * @Date 2020/9/9 9:44
 * @Description 默认的一些 MYSQL 函数实现，已基本覆盖，特殊函数需自定义扩展。
 */
public class DefaultH2Functions extends H2Functions {

    @Override
    protected void add() {
        Set<H2Function> h2FunctionSet = defaultH2Functions();
        super.addAll(h2FunctionSet);
    }

    private Set<H2Function> defaultH2Functions() {
        Set<H2Function> h2FunctionSet = new HashSet<>();
        // date & time
        h2FunctionSet.add(new H2Function("ADDDATE", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.addDate"));
        h2FunctionSet.add(new H2Function("ADDTIME", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.addTime"));
        h2FunctionSet.add(new H2Function("TIME", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.time"));
        h2FunctionSet.add(new H2Function("UTC_TIMESTAMP", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.utcTimestamp"));
        h2FunctionSet.add(new H2Function("UTC_DATE", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.utcDate"));
        h2FunctionSet.add(new H2Function("UTC_TIME", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.utcTime"));
        h2FunctionSet.add(new H2Function("FROM_DAYS", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.fromDays"));
        h2FunctionSet.add(new H2Function("TO_DAYS", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.toDays"));
        h2FunctionSet.add(new H2Function("TO_SECONDS", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.toSeconds"));
        h2FunctionSet.add(new H2Function("TIME_TO_SEC", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.timeToSeconds"));
        h2FunctionSet.add(new H2Function("DATE_FORMAT", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.dateFormat"));
        h2FunctionSet.add(new H2Function("TIME_FORMAT", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.timeFormat"));
        h2FunctionSet.add(new H2Function("LAST_DAY", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.lastDay"));
        h2FunctionSet.add(new H2Function("MAKEDATE", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.makeDate"));
        h2FunctionSet.add(new H2Function("MAKETIME", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.makeTime"));
        h2FunctionSet.add(new H2Function("SEC_TO_TIME", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.secondsToTime"));
        h2FunctionSet.add(new H2Function("SLEEP", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.sleep"));
        h2FunctionSet.add(new H2Function("STR_TO_DATE", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.strToDate"));
        h2FunctionSet.add(new H2Function("SUBDATE", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.subDate"));
        h2FunctionSet.add(new H2Function("SUBTIME", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.subTime"));
        h2FunctionSet.add(new H2Function("YEARWEEK", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.yearWeek"));
        h2FunctionSet.add(new H2Function("WEEKOFYEAR", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.weekOfYear"));
        h2FunctionSet.add(new H2Function("WEEKDAY", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.weekDay"));
        h2FunctionSet.add(new H2Function("MICROSECOND", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.microSecond"));
        h2FunctionSet.add(new H2Function("CONVERT_TZ", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.convertTZ"));
        h2FunctionSet.add(new H2Function("PERIOD_ADD", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.periodAdd"));
        h2FunctionSet.add(new H2Function("PERIOD_DIFF", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.periodDiff"));
        h2FunctionSet.add(new H2Function("TIMEDIFF", "com.lucky.ut.effective.h2.mysql.DateTimeFunctions.timeDiff"));
        // encrypt
        h2FunctionSet.add(new H2Function("MD5", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.md5"));
        h2FunctionSet.add(new H2Function("SHA1", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.sha1"));
        h2FunctionSet.add(new H2Function("SHA", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.sha"));
        h2FunctionSet.add(new H2Function("HEX", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.hex"));
        h2FunctionSet.add(new H2Function("UNHEX", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.unhex"));
        h2FunctionSet.add(new H2Function("PASSWORD", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.password"));
        h2FunctionSet.add(new H2Function("TO_BASE64", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.base64"));
        h2FunctionSet.add(new H2Function("FROM_BASE64", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.unbase64"));
        h2FunctionSet.add(new H2Function("RANDOM_BYTES", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.randomBytes"));
        h2FunctionSet.add(new H2Function("AES_ENCRYPT", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.aesEncrypt"));
        h2FunctionSet.add(new H2Function("AES_DECRYPT", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.aesDecrypt"));
        h2FunctionSet.add(new H2Function("CRC32", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.crc32"));
        h2FunctionSet.add(new H2Function("CREATE_DIGEST", "com.lucky.ut.effective.h2.mysql.EncryptionFunctions.createDigest"));
        // string functions
        h2FunctionSet.add(new H2Function("BIN", "com.lucky.ut.effective.h2.mysql.StringFunctions.bin"));
        h2FunctionSet.add(new H2Function("UUID_SHORT", "com.lucky.ut.effective.h2.mysql.StringFunctions.uuidShort"));
        h2FunctionSet.add(new H2Function("FIND_IN_SET", "com.lucky.ut.effective.h2.mysql.StringFunctions.findInSet"));
        h2FunctionSet.add(new H2Function("IS_IPV4", "com.lucky.ut.effective.h2.mysql.StringFunctions.isIpv4"));
        h2FunctionSet.add(new H2Function("IS_IPV6", "com.lucky.ut.effective.h2.mysql.StringFunctions.isIpv6"));
        h2FunctionSet.add(new H2Function("IS_UUID", "com.lucky.ut.effective.h2.mysql.StringFunctions.isUUID"));
        h2FunctionSet.add(new H2Function("REVERSE", "com.lucky.ut.effective.h2.mysql.StringFunctions.reverse"));
        h2FunctionSet.add(new H2Function("SUBSTRING_INDEX", "com.lucky.ut.effective.h2.mysql.StringFunctions.subStringIndex"));
        h2FunctionSet.add(new H2Function("STRCMP", "com.lucky.ut.effective.h2.mysql.StringFunctions.strCmp"));
        h2FunctionSet.add(new H2Function("CHARSET", "com.lucky.ut.effective.h2.mysql.StringFunctions.charset"));
        h2FunctionSet.add(new H2Function("FIELD", "com.lucky.ut.effective.h2.mysql.StringFunctions.field"));
        h2FunctionSet.add(new H2Function("MID", "com.lucky.ut.effective.h2.mysql.StringFunctions.mid"));
        h2FunctionSet.add(new H2Function("ORD", "com.lucky.ut.effective.h2.mysql.StringFunctions.ord"));
        h2FunctionSet.add(new H2Function("QUOTE", "com.lucky.ut.effective.h2.mysql.StringFunctions.quote"));
        // math functions
        h2FunctionSet.add(new H2Function("POW", "com.lucky.ut.effective.h2.mysql.MathFunctions.pow"));
        h2FunctionSet.add(new H2Function("CONV", "com.lucky.ut.effective.h2.mysql.MathFunctions.conv"));
        // misc
        h2FunctionSet.add(new H2Function("FORMAT", "com.lucky.ut.effective.h2.mysql.MiscFunctions.format"));
        h2FunctionSet.add(new H2Function("VERSION", "com.lucky.ut.effective.h2.mysql.MiscFunctions.version"));
        h2FunctionSet.add(new H2Function("CONNECTION_ID", "com.lucky.ut.effective.h2.mysql.MiscFunctions.connectId"));
        h2FunctionSet.add(new H2Function("SESSION_USER", "com.lucky.ut.effective.h2.mysql.MiscFunctions.sessionUser"));
        h2FunctionSet.add(new H2Function("SYSTEM_USER", "com.lucky.ut.effective.h2.mysql.MiscFunctions.sessionUser"));
        h2FunctionSet.add(new H2Function("CURRENT_ROLE", "com.lucky.ut.effective.h2.mysql.MiscFunctions.currentRole"));
        return h2FunctionSet;
    }
}
