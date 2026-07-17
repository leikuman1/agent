package com.mycopilotx.ai.demo;


import com.mycopilotx.common.result.WebResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoAgentController {
    private final DemoAgentService agentService;

    public DemoAgentController(DemoAgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/agent")
    public WebResult<DemoAgentState> chat(
            @Valid @RequestBody DemoAgentRequest request) {
        return WebResult.success(agentService.run(request.question()));
    }
}
