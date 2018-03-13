/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.bval.constraints;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Function;

import javax.validation.ConstraintValidator;
import javax.validation.constraints.Future;

/**
 * Defines built-in {@link ConstraintValidator} implementations for {@link Future}.
 *
 * @param <T>
 *            validated type
 */
public abstract class FutureValidator<T extends Comparable<T>> extends TimeValidator<Future, T> {

    public static class ForDate extends FutureValidator<Date> {

        public ForDate() {
            super(clock -> Date.from(clock.instant()));
        }
    }

    public static class ForCalendar extends FutureValidator<Calendar> {

        public ForCalendar() {
            super(clock -> GregorianCalendar.from(clock.instant().atZone(clock.getZone())));
        }
    }

    public static class ForInstant extends FutureValidator<Instant> {

        public ForInstant() {
            super(Instant::now);
        }
    }

    public static class ForChronoLocalDate extends FutureValidator<ChronoLocalDate> {

        public ForChronoLocalDate() {
            super(LocalDate::now);
        }
    }

    public static class ForChronoLocalDateTime extends FutureValidator<ChronoLocalDateTime<?>> {

        public ForChronoLocalDateTime() {
            super(LocalDateTime::now);
        }
    }

    public static class ForLocalTime extends FutureValidator<LocalTime> {

        public ForLocalTime() {
            super(LocalTime::now);
        }
    }

    public static class ForOffsetDateTime extends FutureValidator<OffsetDateTime> {

        public ForOffsetDateTime() {
            super(OffsetDateTime::now);
        }
    }

    public static class ForOffsetTime extends FutureValidator<OffsetTime> {

        public ForOffsetTime() {
            super(OffsetTime::now);
        }
    }

    public static class ForChronoZonedDateTime extends FutureValidator<ChronoZonedDateTime<?>> {

        public ForChronoZonedDateTime() {
            super(ZonedDateTime::now);
        }
    }

    public static class ForMonthDay extends FutureValidator<MonthDay> {

        public ForMonthDay() {
            super(MonthDay::now);
        }
    }

    public static class ForYear extends FutureValidator<Year> {

        public ForYear() {
            super(Year::now);
        }
    }

    public static class ForYearMonth extends FutureValidator<YearMonth> {

        public ForYearMonth() {
            super(YearMonth::now);
        }
    }

    protected FutureValidator(Function<Clock, T> now) {
        super(now, n -> n > 0);
    }
}