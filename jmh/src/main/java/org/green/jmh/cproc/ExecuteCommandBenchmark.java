/**
 * MIT License
 * <p>
 * Copyright (c) 2019 Anatoly Gudkov
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.green.jmh.cproc;

import org.green.cproc.ConcurrentProcessClosedException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

@Fork(3)
@Measurement(iterations = 3)
@Warmup(iterations = 3)
@BenchmarkMode(Mode.Throughput)
public class ExecuteCommandBenchmark extends ConcurrentProcessBenchmark {

    @Benchmark
    @Threads(1)
    public void oneStartExecuteCallerWithCabBlocking(
            final CabBlockingBasedProcessSetup processSetup)
            throws ConcurrentProcessClosedException, InterruptedException {

        processSetup.process.start().execute();
    }

    @Benchmark
    @Threads(2)
    public void twoStartExecuteCallersWithCabBlocking(
            final CabBlockingBasedProcessSetup processSetup)
            throws ConcurrentProcessClosedException, InterruptedException {

        processSetup.process.start().execute();
    }

    @Benchmark
    @Threads(1)
    public void oneStartExecuteCallerWithCabBackingOff(
            final CabBackingOffBasedProcessSetup processSetup)
            throws ConcurrentProcessClosedException, InterruptedException {

        processSetup.process.start().execute();
    }

    @Benchmark
    @Threads(2)
    public void twoStartExecuteCallersWithCabBackingOff(
            final CabBackingOffBasedProcessSetup processSetup)
            throws ConcurrentProcessClosedException, InterruptedException {

        processSetup.process.start().execute();
    }

    @Benchmark
    @Threads(1)
    public void oneStartExecuteCallerWithCabYielding(
            final CabYieldingBasedProcessSetup processSetup)
            throws ConcurrentProcessClosedException, InterruptedException {

        processSetup.process.start().execute();
    }

    @Benchmark
    @Threads(2)
    public void twoStartExecuteCallersWithCabYielding(
            final CabYieldingBasedProcessSetup processSetup)
            throws ConcurrentProcessClosedException, InterruptedException {

        processSetup.process.start().execute();
    }
}