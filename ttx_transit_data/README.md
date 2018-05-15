## Updating GTFS and GBFS files

### GTFS
GTFS files are distributed as zipfiles of .txt files (in CSV format).
You can download the most recent GTFS files for Toronto-area transit at https://transitfeeds.com/l/46-ontario-canada.
Place the zip files in `ttx_transit_data/toronto/` and name them as:
`transit_agency_name_date_month_yearofpublication`, e.g. `ttc_gtfs_5_oct_2017`.

Don't forget to copy over the entire ttx_transit_data/toronto dir to transit_data/toronto before
running.

### GBFS
GBFS files are distributed as a set of JSON files.
We only use the station_information.json file of the [GBFS spec](https://github.com/NABSA/gbfs/blob/master/gbfs.md#files).

We manually download and zip the most recent station_information.json file (more info on why below).
To do so:
* Go to [Toronto's open data portal](https://www.toronto.ca/city-government/data-research-maps/open-data/open-data-catalogue/#84045f23-7465-0892-8889-7b6f91049b29) and click Bike Share - JSON.
* Go to the URL specified under "station_information"; something like https://tor.publicbikesystem.net/ube/gbfs/v1/en/station_status.
* Copy the contents of this file into a new file at ttx_transit_data/toronto/station_information.json
* `zip -rj ttx_transit_data/toronto/to_bikeshare_date_of_publication.zip ttx_transit_data/toronto/station_information.json`.
-rj ensures that when the zip file is unzipped the contents won't be contained inside a dir.

Why we download:
To preserve control over data versions, we maintain a versioned store of GBFS data rather than
redownloading the JSON files from their online locations each build. This requires downloading
and storing the individual JSON files.

Why we zip:
We could keep them in a folder, but there are some small benefits to using a zip file; namely,
the TNBuilderConfig currently has a field for only one bikeshare file (I believe this to be a
vestige of the old xml bikeshare format, but nevertheless that's the way it is currently) and a
zip file is an easy way to point to one file; also, this allows us to piggyback off the
TransportNetwork code that determines whether a zipfile is GTFS or another type by looking at its
contents.
