//arquivo pra pegar de exemplo o que o professor passou

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping // (localhost/api)
@RequiredArgsConstructor

public class ApiController {
    private final QueueProcessorService queueProcessorService;

    @PostMapping(/* link */ "/ingest/{deviceId}/{timestamp}")
    public ResponseEntity<String> ingestDataPost(
            @PathVariable String deviceId,
            @PathVariable long timestamp,
            @RequestBody(required = false) String payload) {
        String finalPayload = payload != null ? payload : "";
        IngestData data = new IngestData(deviceId, timestamp, finalPayload);
        queueService.addToQueue(data);
        return ResponseEntity.accepted().body("Data added to queue");
    }

    @PutMapping(/* link */ "/ingest/{deviceId}/{json}")
    public String ingestDataPut(
            @PathVariable String deviceId,
            @RequestBody (required = false) String payload)
            @PathVariable String json {
        String finalPayload = payload != null ? payload : "";
        IngestData data = new IngestData(deviceId, timestamp, finalPayload);
        data.save();
        queueService.addToQueue(data);
        return "Essa foi galera";
    }

    @PostMapping(/*link */ "/{entity}/{action}/{deviceId}")
    public ResponseEntity<String> handleRequestWithDevicePost(
        @PathVariable String entity,
        @PathVariable String action,
        @PathVariable String deviceId,
    )

} */