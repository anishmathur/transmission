package com.hack.TransmissionLineService.web;
/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hack.TransmissionLineService.domain.Generation;
import com.hack.TransmissionLineService.service.TransmissionLineService;

@RestController
@RequestMapping(value="/lines")
public class SampleController {

	@Autowired
	private TransmissionLineService transmissionLineService;
	@RequestMapping(value="/{line}", method=RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public String transmissionLineName(@PathVariable String line) {
		//TestLine1
		return transmissionLineService.getTransmissionLine(line).getName();
	}

	@RequestMapping(value="/{line}/generations", method=RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public Set<Generation> generationLevelsforLine(@PathVariable String line) {
		//TestLine1
		return transmissionLineService.getTransmissionLine(line).getGenerations();
	}
}
