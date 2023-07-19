package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {
    private final ViewRepository viewRepository;

    public ViewController(ViewRepository repo) {
        this.viewRepository = repo;
    }
    
    /*
    Create View: POST /view with body: { “name”: “...”, “chartType”: “column”, “country”: “IN”, “indicator”: “1.0.HCount.1.90usd", “startDate”:”...”, “endDate”: “...”}
    Returns http 201 when successful . 4XX if bad data. 5XX if server error

    List all Views: GET /view : returns:
    [{ “viewId”: “v111”, “name”: “...”, “chartType”: “column”, “country”: “IN”, “indicator”: “1.0.HCount.1.90usd", “startDate”:”...”, “endDate”: “...”} ]
    Returns http 200 when successful . 5XX if server error

    Fetch a View by ID: GET /view/<viewId>
    Returns http 200 when successful . 4XX if bad viewId. 5XX if server error

    Delete a View: DELETE /view/<viewId>
    Returns http 200 when successful . 4XX if bad viewId. 5XX if server error
    */

    @PostMapping
    public ResponseEntity createView(@RequestBody View view) throws URISyntaxException {
        View savedView = viewRepository.save(view);

        if (savedView.getName() == null ||
                savedView.getCountry() == null ||
                savedView.getIndicator() == null ||
                savedView.getStartDate() == null ||
                savedView.getEndDate() == null) {

            viewRepository.deleteById(savedView.getId());
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.created(new URI("/view/" + savedView.getId())).body(savedView);
    }

    @GetMapping
    public List<View> getAllViews() {
        return viewRepository.findAll();
    }

    @GetMapping("/{id}")
    public View getView(@PathVariable Long id) throws URISyntaxException {
//        if (viewRepository.existsById(id)) {
//            View view = viewRepository.getReferenceById(id);
//            return ResponseEntity.created(new URI("/view/" + id)).body(view);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
        return viewRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteView(@PathVariable Long id) {
        if (viewRepository.existsById(id)) {
            viewRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
