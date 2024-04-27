/*******************************************************************************
 * Copyright (C) 2018, OpenRefine contributors
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/

package com.google.refine.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import com.google.refine.util.TestUtils;

public class ReconCandidateTests {

    String jsonInt = "{\"id\":\"Q49213\","
            + "\"name\":\"University of Texas at Austin\","
            + "\"score\":100,"
            + "\"types\":[\"Q875538\",\"Q15936437\",\"Q20971972\",\"Q23002039\"]}";
    String jsonDouble = "{\"id\":\"Q49213\","
            + "\"name\":\"University of Texas at Austin\","
            + "\"score\":0.5,"
            + "\"types\":[\"Q875538\",\"Q15936437\",\"Q20971972\",\"Q23002039\"]}";

    @Test
    public void serializeReconCandidateInt() throws Exception {
        ReconCandidate rc = ReconCandidate.loadStreaming(jsonInt);
        TestUtils.isSerializedTo(rc, jsonInt);
    }

    @Test
    public void serializeReconCandidateDouble() throws Exception {
        ReconCandidate rc = ReconCandidate.loadStreaming(jsonDouble);
        TestUtils.isSerializedTo(rc, jsonDouble);
    }

    @Test
    public void testEqualsAndHashCode() throws Exception {
        ReconCandidate rc1 = ReconCandidate.loadStreaming(jsonInt);
        assertEquals(rc1, ReconCandidate.loadStreaming(jsonInt));
        assertNotEquals(rc1, ReconCandidate.loadStreaming(jsonDouble));
        assertNotEquals(rc1, "string");
        assertEquals(rc1.hashCode(), ReconCandidate.loadStreaming(jsonInt).hashCode());
    }
}
